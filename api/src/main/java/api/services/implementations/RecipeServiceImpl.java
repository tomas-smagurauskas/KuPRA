package api.services.implementations;

import api.domain.entities.recipes.Recipe;
import api.domain.entities.recipes.RecipeIngredient;
import api.domain.entities.recipes.RecipePhoto;
import api.domain.repositories.RecipeIngredientRepository;
import api.domain.repositories.RecipePhotoRepository;
import api.domain.repositories.RecipeRepository;
import api.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomas on 14.12.13.
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipePhotoRepository recipePhotoRepository;

    @Autowired
    RecipeIngredientRepository recipeIngredientRepository;

    @Override
    @Transactional
    public Recipe createRecipe(Recipe recipe) {

        List<RecipePhoto> recipePhotos = new ArrayList<>();
        List<RecipeIngredient> recipeIngredients = new ArrayList<>();

        if (recipe.getRecipePhoto() != null) {
            for (RecipePhoto recipePhoto : recipe.getRecipePhoto()) {
                recipePhotos.add(recipePhotoRepository.saveAndFlush(recipePhoto));
            }
        }

        if (recipe.getRecipeIngredients() != null) {
            for (RecipeIngredient recipeIngredient : recipe.getRecipeIngredients()) {
                recipeIngredients.add(recipeIngredientRepository.saveAndFlush(recipeIngredient));
            }
        }

        recipe.setRecipeIngredients(recipeIngredients);
        recipe.setRecipePhoto(recipePhotos);

        recipe = recipeRepository.saveAndFlush(recipe);

        return recipe;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {

        List<RecipePhoto> recipePhotos = new ArrayList<>();
        List<RecipeIngredient> recipeIngredients = new ArrayList<>();

        if (recipe.getRecipePhoto() != null) {
            for (RecipePhoto recipePhoto : recipe.getRecipePhoto()) {
                recipePhotos.add(recipePhotoRepository.saveAndFlush(recipePhoto));
            }
        }

        if (recipe.getRecipeIngredients() != null) {
            for (RecipeIngredient recipeIngredient : recipe.getRecipeIngredients()) {
                recipeIngredients.add(recipeIngredientRepository.saveAndFlush(recipeIngredient));
            }
        }

        recipe.setRecipePhoto(recipePhotos);
        recipe.setRecipeIngredients(recipeIngredients);

        return recipeRepository.saveAndFlush(recipe);
    }

    @Override
    public Recipe getById(Integer id) {
        return recipeRepository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        recipeRepository.delete(id);
    }

}
