package church.jack.inventorymanagement.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p INNER JOIN p.productSuppliers ps INNER JOIN ps.id psid WHERE psid.supplierId = ?1")
    List<Product> listProductsBySupplier(Long id);

    Product findById(long id);
}
