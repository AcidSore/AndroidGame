package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import persist.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
