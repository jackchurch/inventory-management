package church.jack.inventorymanagement.productSupplier;

import church.jack.inventorymanagement.product.Product;
import church.jack.inventorymanagement.productSupplierId.ProductSupplierId;
import church.jack.inventorymanagement.supplier.Supplier;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "ProductSupplier")
@Table(name = "product_supplier")
public class ProductSupplier {
    //Variables

    @EmbeddedId
    private ProductSupplierId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name="product_id", foreignKey = @ForeignKey(name="productsupplier_product_fk"))
    private Product product;

    @ManyToOne
    @MapsId("supplierId")
    @JoinColumn(name="supplier_id", foreignKey = @ForeignKey(name="productsupplier_supplier_fk"))
    private Supplier supplier;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createdAt;

    @Column(name = "supplier_cost", nullable = false)
    private Double supplierCost;

    //Constructors
    public ProductSupplier() {
    }

    public ProductSupplier(Product product, Supplier supplier, LocalDateTime createdAt, Double supplierCost) {
        this.product = product;
        this.supplier = supplier;
        this.createdAt = createdAt;
        this.supplierCost = supplierCost;
    }

    public ProductSupplier(ProductSupplierId id, Product product, Supplier supplier, LocalDateTime createdAt, Double supplierCost) {
        this.id = id;
        this.product = product;
        this.supplier = supplier;
        this.createdAt = createdAt;
        this.supplierCost = supplierCost;
    }

//Methods

    @Override
    public String toString() {
        return "ProductSupplier{" +
                "id=" + id +
                ", product=" + product +
                ", supplier=" + supplier +
                ", createdAt=" + createdAt +
                ", supplierCost=" + supplierCost +
                '}';
    }


    //Getters and setters

    public ProductSupplierId getId() {
        return id;
    }

    public void setId(ProductSupplierId id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Double getSupplierCost() {
        return supplierCost;
    }

    public void setSupplierCost(Double supplierCost) {
        this.supplierCost = supplierCost;
    }
}

