package pl._1loaf.model;

public enum RecipeStatus {
    NORMALIZED("Normalized"),
    CALCULATED("Personalized");

    final String statusName;

    RecipeStatus(String statusName) {
        this.statusName = statusName;
    }

    public String getName() {
        return statusName;
    }
}
