package church.jack.inventorymanagement.productSupplierId;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductSupplierId implements Serializable {
    //Variables
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "supplier_id")
    private Long supplierId;

    //Constructors

    public ProductSupplierId() {
    }

    public ProductSupplierId(Long productId, Long supplierId) {
        this.productId = productId;
        this.supplierId = supplierId;
    }

    //Methods

    @Override
    public String toString() {
        return "ProductSupplierId{" +
                "productId=" + productId +
                ", supplierId=" + supplierId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductSupplierId that = (ProductSupplierId) o;
        return Objects.equals(productId, that.productId) && Objects.equals(supplierId, that.supplierId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, supplierId);
    }

    //Getters and setters

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
