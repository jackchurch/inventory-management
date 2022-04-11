package church.jack.inventorymanagement.product;

import church.jack.inventorymanagement.productSupplier.ProductSupplier;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Product")
@Table(name = "product")
public class Product {
    //Instance variables

    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "barcode", nullable = true)
    private String barcode;

    @Column(name = "weightKg", nullable = false)
    private Double weightKg;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "product")
    private List<ProductSupplier> productSuppliers = new ArrayList<>();

    //Constructors

    public Product() {
    }

    public Product(String name, String barcode, Double weightKg) {
        this.name = name;
        this.barcode = barcode;
        this.weightKg = weightKg;
    }

//Methods

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", barcode='" + barcode + '\'' +
                ", weightKg=" + weightKg +
                '}';
    }

    public void addProductSupplier(ProductSupplier ps) {
        if (!productSuppliers.contains(ps)) {
            productSuppliers.add(ps);
        }
    }

    public void removeProductSupplier(ProductSupplier ps) {
        productSuppliers.remove(ps);
        ps.setProduct(null);
    }



    //Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Double weightKg) {
        this.weightKg = weightKg;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public List<ProductSupplier> getProductSuppliers() {
        return productSuppliers;
    }

    public void setProductSuppliers(List<ProductSupplier> productSuppliers) {
        this.productSuppliers = productSuppliers;
    }
}

