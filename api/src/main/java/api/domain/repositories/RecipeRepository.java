package api.domain.repositories;

import api.domain.entities.recipes.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tomas on 14.12.13.
 */
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
