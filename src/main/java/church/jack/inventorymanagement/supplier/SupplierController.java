package church.jack.inventorymanagement.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "v1/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<Supplier> getSupplier() {
        return supplierService.getSuppliers();
    }

    @PostMapping
    public void addNewSupplier(@RequestBody Supplier supplier) {
        supplierService.addNewSupplier(supplier);
    }

    @DeleteMapping(path = "{id}")
    public void deleteSupplier(@PathVariable("id") Long id) {
        supplierService.deleteSupplier(id);
    }

    @PutMapping(path = "{id}")
    public void updateSupplier(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String address) {
        supplierService.updateSupplier(id, name, address);
    }
}
