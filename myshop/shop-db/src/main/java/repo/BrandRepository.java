package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import persist.model.Brand;

public interface BrandRepository extends JpaRepository<Brand,Long> {
}
