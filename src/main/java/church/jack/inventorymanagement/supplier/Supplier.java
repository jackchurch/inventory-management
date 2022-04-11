package church.jack.inventorymanagement.supplier;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Supplier")
@Table(name = "supplier")
public class Supplier {


    //Instance variables
    @Id
    @SequenceGenerator(name = "supplier_sequence", sequenceName = "supplier_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "supplier_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "address", nullable = false, columnDefinition = "TEXT")
    private String address;

    //Constructors

    public Supplier() {
    }

    public Supplier(String name, String address) {
        this.name = name;
        this.address = address;
    }


    //Methods
    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
