package pl._1loaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl._1loaf.model.RecipeEntity;

@Repository
public interface RecipeEntityRepository extends JpaRepository<RecipeEntity, Long> {
}
