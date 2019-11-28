package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import persist.model.Discount;

public interface DiscountRepository extends JpaRepository<Discount,Long> {
}
