package api.services.implementations;

import api.domain.entities.ingredients.Ingredient;
import api.domain.repositories.IngredientRepository;
import api.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tomas on 14.12.13.
 */
@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public Ingredient getById(Integer id) {
        return ingredientRepository.findOne(id);
    }

    @Override
    public List<Ingredient> getAll() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        return ingredients;
    }

    @Override
    public Ingredient create(Ingredient ingredient) {
        return ingredientRepository.saveAndFlush(ingredient);
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        return ingredientRepository.saveAndFlush(ingredient);
    }

    @Override
    public void delete(Integer id) {
        ingredientRepository.delete(id);
        return;
    }
}
