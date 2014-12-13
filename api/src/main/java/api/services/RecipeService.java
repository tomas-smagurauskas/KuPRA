package api.services;

import api.domain.entities.recipes.Recipe;

import java.util.List;

/**
 * Created by tomas on 14.12.13.
 */
public interface RecipeService {

    public Recipe createRecipe(Recipe recipe);
    public List<Recipe> getAllRecipes();
    public Recipe updateRecipe(Recipe recipe);
    public Recipe getById(Integer id);
    public void delete(Integer id);

}
