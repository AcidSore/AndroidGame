package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import persist.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
