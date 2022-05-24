package chef.vegetableCrops;

import java.util.Objects;

public abstract class Vegetable {

    private String name;
    private String vegetableCrops;
    private double caloriesPer100g;
    private double weight;

    public Vegetable(String name, double weight, double calories) {

        if (calories < 0)
            throw new IllegalArgumentException("Can't create vegetable with " + calories + "kcal");
        if (weight < Double.MIN_NORMAL)
            throw new IllegalArgumentException("Can't create " + weight + "g of " + name);

        this.name = name;
        this.caloriesPer100g = calories;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public void setCaloriesPer100g(double caloriesPer100g) {
        this.caloriesPer100g = caloriesPer100g;
    }

    public String getVegetableCrops() {
        return vegetableCrops;
    }

    public void setVegetableCrops(String vegetableCrops) {
        this.vegetableCrops = vegetableCrops;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTotalCalories() {
        return caloriesPer100g * weight / 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vegetable vegetable = (Vegetable) o;
        return Double.compare(vegetable.caloriesPer100g, caloriesPer100g) == 0 && Double.compare(vegetable.weight, weight) == 0 && Objects.equals(name, vegetable.name) && Objects.equals(vegetableCrops, vegetable.vegetableCrops);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vegetableCrops, caloriesPer100g, weight);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("weight=").append(weight).append(", ");
        sb.append("name='").append(name).append("', ");
        sb.append("vegetable crops=").append(vegetableCrops).append(", ");
        sb.append("total calories=").append(getTotalCalories()).append("}");
        return sb.toString();
    }
}
