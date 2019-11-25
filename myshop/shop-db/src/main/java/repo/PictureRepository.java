package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import persist.model.Picture;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
