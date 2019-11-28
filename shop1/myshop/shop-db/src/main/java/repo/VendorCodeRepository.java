package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import persist.model.VendorCode;

public interface VendorCodeRepository extends JpaRepository<VendorCode, Long> {
}
