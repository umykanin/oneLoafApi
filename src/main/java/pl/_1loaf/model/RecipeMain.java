package pl._1loaf.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class RecipeMain {

    private String name;
    private String description;
    private String recipeStatus;
    private Map<String, Double> recipeMap;
    private Double totalWeight;
    private Double unitWeight;
    private Double quantity;
    private String dateTime;

    public RecipeMain(String name, String description, String recipeStatus,
                      Map<String, Double> recipeMap, String dateTime) {
        this.name = name;
        this.description = description;
        this.recipeStatus = recipeStatus;
        this.recipeMap = recipeMap;
        this.totalWeight = getTotalWeight();
        this.dateTime = dateTime;
    }

    public RecipeMain(String name, String description, String recipeStatus,
                      Map<String, Double> recipeMap, Double uniWeight, Double quantity, String dateTime) {
        this.name = name;
        this.description = description;
        this.recipeStatus = recipeStatus;
        this.recipeMap = recipeMap;
        this.totalWeight = getTotalWeight();
        this.dateTime = dateTime;
        this.unitWeight = uniWeight;
        this.quantity = quantity;
    }

    public double getTotalWeight() {
        return recipeMap.size() > 0 ? recipeMap.values().stream().reduce(0D, Double::sum) : 0D;
    }
}
