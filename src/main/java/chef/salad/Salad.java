package chef.salad;

import chef.vegetableCrops.Vegetable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Salad {

    private String name;
    private final List<Vegetable> ingredients = new ArrayList<>();

    public Salad(String name)  {
            this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addIngredient(Vegetable vegetable) {
        ingredients.add(vegetable);
    }

    public void sortedIngredientsByName() {
        ingredients.sort(Comparator.comparing(Vegetable::getName));
        ingredients.forEach(System.out::println);
    }

    public void sortedIngredientsByWeight() {
        ingredients.sort(Comparator.comparing(Vegetable::getWeight));
        ingredients.forEach(System.out::println);
    }

    public void sortedIngredientsByCalories() {
        ingredients.sort(Comparator.comparing(Vegetable::getTotalCalories));
        ingredients.forEach(System.out::println);
    }

    public void showIngredientsInCalorieRange(double underCalories, double upperCalories) {
        System.out.printf("Ingredients for calories [ %.2f - %.2f ] " +
                "per 100 g. of product: \n",underCalories, upperCalories );
        ingredients.stream().filter( vegetable -> vegetable.getCaloriesPer100g() <= upperCalories
                        && vegetable.getCaloriesPer100g() >= underCalories).forEach(System.out::println);

    }

    public void showRecipe() {
        if (ingredients.isEmpty())
            System.out.println("You haven't added any ingredients yet.");

        System.out.printf("Salad %s contains: \n", name);
        ingredients.forEach(System.out::println);
        System.out.println("Salad weight is " + showWeight() + "g.");
        System.out.println("Salad calories is " + showCalories() + " kcal.");
    }

    private double showWeight() {
        double weight = 0.0;
        for (Vegetable vegetable : ingredients) {
            weight += vegetable.getWeight();
        }
        return weight;
    }

    private double showCalories() {
        double calories = 0.0;
        for (Vegetable vegetables : ingredients) {
            calories += vegetables.getTotalCalories();
        }
        return calories;
    }

}
