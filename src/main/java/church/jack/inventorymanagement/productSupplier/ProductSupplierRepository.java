package church.jack.inventorymanagement.productSupplier;

import church.jack.inventorymanagement.product.Product;
import church.jack.inventorymanagement.productSupplierId.ProductSupplierId;
import church.jack.inventorymanagement.supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, ProductSupplierId> {





}
