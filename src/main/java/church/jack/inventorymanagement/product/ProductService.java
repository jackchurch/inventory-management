package church.jack.inventorymanagement.product;

import church.jack.inventorymanagement.productSupplier.ProductSupplier;
import church.jack.inventorymanagement.productSupplierId.ProductSupplierId;
import church.jack.inventorymanagement.supplier.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addNewProduct(Product product, Supplier supplier, Double supplierCost) {
        productRepository.save(product);
        product.addProductSupplier(new ProductSupplier(
                new ProductSupplierId(product.getId(), supplier.getId()),
                product, supplier, LocalDateTime.now(), supplierCost));

    }

    public void deleteProduct(Long id) {
        boolean exists = productRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Supplier with id " + id + " does not exist. ");
        } else {
            productRepository.deleteById(id);
        }
    }

    @Transactional
    public void updateProduct(Long id, String name, String barcode, Double weightKg) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Product with id " + id +
                        " does not exist. "));

        if (name != null && name.length() > 0 && !Objects.equals(product.getName(), name)) {
            product.setName(name);
        }
        if (barcode != null && barcode.length() > 0 && !Objects.equals(product.getBarcode(), barcode)) {
            product.setBarcode(barcode);
        }
        if (weightKg != null && weightKg > 0 && !Objects.equals(product.getWeightKg(), weightKg)) {
            product.setWeightKg(weightKg);
        }
    }


}
