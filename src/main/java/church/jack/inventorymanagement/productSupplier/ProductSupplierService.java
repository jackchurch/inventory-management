package church.jack.inventorymanagement.productSupplier;

import church.jack.inventorymanagement.product.Product;
import church.jack.inventorymanagement.productSupplierId.ProductSupplierId;
import church.jack.inventorymanagement.supplier.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductSupplierService {
    private final ProductSupplierRepository productSupplierRepository;

    @Autowired
    public ProductSupplierService(ProductSupplierRepository productSupplierRepository) {
        this.productSupplierRepository = productSupplierRepository;
    }

    public List<ProductSupplier> getProductSuppliers() {
        return  productSupplierRepository.findAll();
    }

    public void addNewProductSupplier(ProductSupplier productSupplier) {
        Optional<ProductSupplier> productSupplierOptional =  productSupplierRepository.findById(productSupplier.getId());
        if(productSupplierOptional.isPresent()) {
            throw new IllegalStateException("Product with id " + productSupplier.getId() + " already exists. ");
        } else {
            productSupplierRepository.save(productSupplier);
        }
    }

    public void deleteProductSupplier(ProductSupplierId id) {
        boolean exists = productSupplierRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Product from Supplier with id " + id + " does not exist. ");
        } else {
            productSupplierRepository.deleteById(id);
        }
    }

    @Transactional
    public void updateProductSupplier(ProductSupplierId id, Product product, Supplier supplier, LocalDateTime now, Double supplierCost) {
        ProductSupplier productSupplier = productSupplierRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("ProductSupplier id " + id + " does not exist. "));

        if (product != null && !Objects.equals(productSupplier.getProduct(), product)) {
            productSupplier.setProduct(product);
        }

        if (supplier != null && !Objects.equals(productSupplier.getSupplier(), supplier)) {
            productSupplier.setSupplier(supplier);
        }

        if (supplierCost != null && supplierCost >= 0 && !Objects.equals(productSupplier.getSupplierCost(), supplierCost)) {
            productSupplier.setSupplierCost(supplierCost);
        }

        productSupplier.setCreatedAt(LocalDateTime.now());

    }

}
