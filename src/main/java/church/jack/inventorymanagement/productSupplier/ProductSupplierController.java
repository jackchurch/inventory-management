package church.jack.inventorymanagement.productSupplier;

import church.jack.inventorymanagement.product.Product;
import church.jack.inventorymanagement.productSupplierId.ProductSupplierId;
import church.jack.inventorymanagement.supplier.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "v1/product-suppliers")
public class ProductSupplierController {

    private final ProductSupplierService productSupplierService;

    @Autowired
    public ProductSupplierController(ProductSupplierService productSupplierService) {
        this.productSupplierService = productSupplierService;
    }

    @GetMapping
    public List<ProductSupplier> getProductSuppliers() {
        return productSupplierService.getProductSuppliers();
    }

    @PostMapping
    public void addProductSupplier(@RequestBody ProductSupplier productSupplier) {
        productSupplierService.addNewProductSupplier(productSupplier);
    }

    @DeleteMapping(path="{id}")
    public void deleteProductSupplier(@PathVariable("id") ProductSupplierId id) {
        productSupplierService.deleteProductSupplier(id);
    }

    @PutMapping(path = "{id}")
    public void updateProductSupplier(
            @PathVariable("id") ProductSupplierId id,
            @RequestParam(required = false) Product product,
            @RequestParam(required = false) Supplier supplier,
            LocalDateTime now,
            @RequestParam(required = false) Double supplierCost) {
        productSupplierService.updateProductSupplier(id, product, supplier, now, supplierCost);
    }
}
