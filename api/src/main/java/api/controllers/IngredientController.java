package api.controllers;

import api.domain.entities.ingredients.Ingredient;
import api.services.IngredientService;
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
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @RequestMapping(value = RestUrls.INGREDIENTS, method = RequestMethod.GET)
    @ResponseBody
    public List<Ingredient> getIngredients(HttpServletResponse response) {

        try {
            List<Ingredient> ingredients = ingredientService.getAll();
            return ingredients;
        }
        catch (Exception e) {
            response.setStatus(500);
            return null;
        }


    }

    @RequestMapping(value = RestUrls.INGREDIENTS, method = RequestMethod.POST)
    @ResponseBody
    public Ingredient createIngredient(@RequestBody Ingredient ingredient, HttpServletResponse response) {

        try {
            ingredient = ingredientService.create(ingredient);
            return ingredient;
        }
        catch (Exception e) {
            response.setStatus(500);
            return null;
        }

    }

    @RequestMapping(value = RestUrls.INGREDIENTS + "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Ingredient getIngredient(@PathVariable(value = "id") String id, HttpServletResponse response) {

        try {
            return ingredientService.getById(Integer.parseInt(id));
        }
        catch (Exception e) {
            response.setStatus(500);
            return null;
        }
    }

    @RequestMapping(value = RestUrls.INGREDIENTS + "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteIngredient(@PathVariable(value = "id") String id, HttpServletResponse response) {

        try {
            ingredientService.delete(Integer.parseInt(id));
            return;
        }
        catch (Exception e) {
            response.setStatus(500);
            return;
        }
    }

    @RequestMapping(value = RestUrls.INGREDIENTS, method = RequestMethod.PUT)
    @ResponseBody
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient, HttpServletResponse response) {

        try {
            return ingredientService.update(ingredient);
        }
        catch (Exception e) {
            response.setStatus(500);
            return null;
        }
    }

}
