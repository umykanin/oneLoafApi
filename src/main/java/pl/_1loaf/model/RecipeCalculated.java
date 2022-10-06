package pl._1loaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecipeCalculated {
// test
    private RecipeMain recipeMain;
    private Double quantity;
    private Double weight;
}
