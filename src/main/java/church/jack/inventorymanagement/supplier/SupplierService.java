package church.jack.inventorymanagement.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    public void addNewSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long id) {
        boolean exists = supplierRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Supplier with id " + id + " does not exist. ");
        } else {
            supplierRepository.deleteById(id);
        }
    }


    //Transactional means we don't need queires. The entites goes into a managed state.
    @Transactional
    public void updateSupplier(Long id, String name, String address) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Supplier with id " + id + " does not exist. "));

        if (name != null && name.length() > 0 && !Objects.equals(supplier.getName(), name)) {
            supplier.setName(name);
        }
        if (address != null && address.length() > 0 && !Objects.equals(supplier.getAddress(), address)) {
            supplier.setAddress(address);
        }
    }
}
