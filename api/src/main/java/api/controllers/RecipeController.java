package api.controllers;

import api.domain.entities.recipes.Recipe;
import api.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.RestUrls;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by tomas on 14.12.13.
 */
@RestController
@RequestMapping(value = RestUrls.APP_MAPPING)
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @RequestMapping(value = RestUrls.RECIPES, method = RequestMethod.POST)
    @ResponseBody
    public Recipe createRecipe(@RequestBody Recipe recipe, HttpServletResponse response) {

        try {
            return recipeService.createRecipe(recipe);
        }
        catch (Exception e) {
            response.setStatus(500);
            return null;
        }

    }

    @RequestMapping(value = RestUrls.RECIPES, method = RequestMethod.GET)
    @ResponseBody
    public List<Recipe> getAllRecipes(HttpServletResponse response) {

        try {
            return recipeService.getAllRecipes();
        }
        catch (Exception e) {
            response.setStatus(500);
            return null;
        }

    }

    @RequestMapping(value = RestUrls.RECIPES + "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Recipe getById(@PathVariable(value = "id") String id, HttpServletResponse response) {

        try {
            return recipeService.getById(Integer.parseInt(id));
        }
        catch (Exception e) {
            response.setStatus(500);
            return null;
        }

    }

    @RequestMapping(value = RestUrls.RECIPES, method = RequestMethod.PUT)
    @ResponseBody
    public Recipe update(@RequestBody Recipe recipe, HttpServletResponse response) {

        try {
            return recipeService.updateRecipe(recipe);
        }
        catch (Exception e) {
            response.setStatus(500);
            return null;
        }

    }

    @RequestMapping(value = RestUrls.RECIPES + "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable(value = "id") String id, HttpServletResponse response) {

        try {
            recipeService.delete(Integer.parseInt(id));
        }
        catch (Exception e) {
            response.setStatus(500);
            return;
        }

    }

}
