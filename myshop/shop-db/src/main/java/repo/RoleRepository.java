package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import persist.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
