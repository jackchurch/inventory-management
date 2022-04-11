package church.jack.inventorymanagement.product;

import church.jack.inventorymanagement.productSupplier.ProductSupplierService;
import church.jack.inventorymanagement.supplier.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "v1/products")
public class ProductController {

    private final ProductService productService;
    private final ProductSupplierService productSupplierService;

    @Autowired
    public ProductController(ProductService productService, ProductSupplierService productSupplierService) {
        this.productService = productService;
        this.productSupplierService = productSupplierService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product, Supplier supplier, Double supplierCost) {
        productService.addNewProduct(product, supplier, supplierCost);
    }

    @DeleteMapping(path = "{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping(path = "{id}")
    public void updateProduct(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String barcode,
            @RequestParam(required = false) Double weightKg) {
        productService.updateProduct(id, name, barcode, weightKg);
    }
}
