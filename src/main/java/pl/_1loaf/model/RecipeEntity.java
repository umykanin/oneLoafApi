package pl._1loaf.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "recipes")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String jsonMap;
    private String dateTime;

    public RecipeEntity(String name, String description, String jsonMap, String dateTime) {
        this.name = name;
        this.description = description;
        this.jsonMap = jsonMap;
        this.dateTime = dateTime;
    }

    public RecipeEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJsonMap() {
        return jsonMap;
    }

    public void setJsonMap(String jsonMap) {
        this.jsonMap = jsonMap;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
