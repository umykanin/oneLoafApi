package pl._1loaf.service;

import org.springframework.stereotype.Service;
import pl._1loaf.model.RecipeCalculated;
import pl._1loaf.model.RecipeMain;
import pl._1loaf.model.RecipeStatus;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeService {

    public static RecipeMain getPersonalised(Double unitWeight, Double quantity, RecipeMain recipe) {
        Map<String, Double> recipeMap = recipe.getRecipeMap();
        Map<String, Double> calculatedMap = new HashMap<>();
        Double factor = unitWeight * quantity / recipe.getTotalWeight();
        recipeMap.forEach((key, value) -> {
            calculatedMap.put(key, value * factor);
        });
        return new RecipeMain(
                recipe.getName(),
                recipe.getDescription(),
                RecipeStatus.CALCULATED.getName(),
                calculatedMap,
                unitWeight,
                quantity,
                recipe.getDateTime());
    }
}
