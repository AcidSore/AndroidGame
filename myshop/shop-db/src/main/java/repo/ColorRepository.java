package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import persist.model.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {
}
