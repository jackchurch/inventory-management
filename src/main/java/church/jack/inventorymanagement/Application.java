package church.jack.inventorymanagement;

import church.jack.inventorymanagement.product.Product;
import church.jack.inventorymanagement.product.ProductRepository;
import church.jack.inventorymanagement.productSupplier.ProductSupplier;
import church.jack.inventorymanagement.productSupplier.ProductSupplierRepository;
import church.jack.inventorymanagement.productSupplierId.ProductSupplierId;
import church.jack.inventorymanagement.supplier.Supplier;
import church.jack.inventorymanagement.supplier.SupplierRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(SupplierRepository supplierRepository,
										ProductRepository productRepository,
										ProductSupplierRepository productSupplierRepository) {
		return args -> {

			LocalDateTime now = LocalDateTime.now();

			Supplier supplier1 = new Supplier("Microsoft", "Washington");
			Supplier supplier2 = new Supplier("Apple", "Califorina");
			Supplier supplier3 = new Supplier("Red Hat", "Georgia");

			supplierRepository.saveAll(List.of(supplier1, supplier2, supplier3));

			Product product1 = new Product("Green Candle", "4894564186", 0.5);
			Product product2 = new Product("Red Candle", "8948964186489", 0.5);
			Product product3 = new Product("Sirloin", null, 1.3);
			Product product4 = new Product("Rump", null, 3.4);

			productRepository.saveAll(List.of(product1, product2, product3, product4));

			ProductSupplier productSupplier1 = new ProductSupplier(
					new ProductSupplierId(product1.getId(), supplier1.getId()),
					product1,
					supplier1,
					now,
					1.95
			);

			productSupplierRepository.save(productSupplier1);

			System.out.println("\n\nproductSupplier1 id: ");
			System.out.println(productSupplier1.getId() + " " + productSupplier1.getSupplierCost());

			System.out.println("\n\nproduct1 id: ");
			System.out.println(product1.getId());
		};

	}
}