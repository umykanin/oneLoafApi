package pl._1loaf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;
import pl._1loaf.dao.RecipeDao;
import pl._1loaf.model.RecipeCalculated;
import pl._1loaf.model.RecipeMain;
import pl._1loaf.service.RecipeService;

import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private final RecipeDao recipeDao;

    public RecipeController(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    @GetMapping("/{id}")
    RecipeMain getRecipeMain(@PathVariable Long id) {
        recipeDao.saveBasicRecipe();
        return recipeDao.getRecipeMainFromRecipeEntity(id);

    }

    //  /p?unitWeight=60&quantity=22
    @GetMapping("p/{id}")
    RecipeMain getPersonalizedRecipe(@PathVariable Long id,
                                              @RequestParam Double unitWeight,
                                              @RequestParam Double quantity) {
        return RecipeService.getPersonalised(unitWeight, quantity, recipeDao.getRecipeMainFromRecipeEntity(id));
    }
}
