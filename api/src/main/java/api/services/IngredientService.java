package api.services;

import api.domain.entities.ingredients.Ingredient;

import java.util.List;

/**
 * Created by tomas on 14.12.13.
 */
public interface IngredientService {

    public Ingredient getById(Integer id);
    public List<Ingredient> getAll();
    public Ingredient create(Ingredient ingredient);
    public Ingredient update(Ingredient ingredient);
    public void delete(Integer id);

}
