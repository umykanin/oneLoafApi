package pl._1loaf.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import pl._1loaf.model.RecipeEntity;
import pl._1loaf.model.RecipeMain;
import pl._1loaf.model.RecipeStatus;
import pl._1loaf.repository.RecipeEntityRepository;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeDao {

    private final RecipeEntityRepository repo;
    private final Gson gson = new Gson();

    public RecipeDao(RecipeEntityRepository repo) {
        this.repo = repo;
    }

    public RecipeMain getRecipeMainFromRecipeEntity(Long id) {
        RecipeEntity recipeEntity = repo.findById(id).orElseThrow();
        Type type = new TypeToken<Map<String, Double>>() {
        }.getType();
        Map<String, Double> recipeMap = gson.fromJson(recipeEntity.getJsonMap(), type);
        return new RecipeMain(
                recipeEntity.getName(),
                recipeEntity.getDescription(),
                RecipeStatus.NORMALIZED.getName(),
                recipeMap,
                0D,
                0D,
                recipeEntity.getDateTime()
                );
    }

    public void saveBasicRecipe() {
        Map<String, Double> recipeMap = new HashMap<>();
        recipeMap.put("Mąka", 1000D);
        recipeMap.put("Woda", 650D);
        recipeMap.put("Sól", 20D);
        String gsonFromMap = gson.toJson(recipeMap);
        RecipeEntity recipeMain = new RecipeEntity(
                "Chleb",
                "Opis jak zrobić chleb",
                gsonFromMap,
                LocalDateTime.now().toString()
        );
        repo.save(recipeMain);
    }
}
