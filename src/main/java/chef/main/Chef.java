package chef.main;

import chef.salad.Salad;
import chef.vegetableCrops.Vegetable;
import chef.vegetables.Carrot;
import chef.vegetables.Cucumber;
import chef.vegetables.Lettuce;
import chef.vegetables.Onion;
import chef.vegetables.Potato;
import chef.vegetables.Tomato;
import chef.vegetables.WhiteCabbage;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Chef {
    private final String nameChef;
    private Salad salad;

    public Chef(String nameChef) {
        this.nameChef = nameChef;
    }

    public void mainMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.printf("Hello! My name is chef %s.\n", nameChef);
            System.out.println("What salad do you want to cook today?");
            salad = new Salad(scanner.nextLine());
            System.out.printf("Salad %s, great chose.\n", salad.getName());
            choiceOfIngredients();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void additionalOptions() {
        int choice = -1;
        try(Scanner scanner = new Scanner(System.in)) {
            while (choice != 0) {
                System.out.println("\nChoose one of the options:");
                System.out.println("1. Change salad name");
                System.out.println("2. Show recipe");
                System.out.println("3. Add ingredient");
                System.out.println("4. Sort ingredients by calories");
                System.out.println("5. Sort ingredients by weight");
                System.out.println("6. Sort ingredients by name");
                System.out.println("7. Get ingredients for calories");
                System.out.println("Press 0 to exit.");
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e){
                    System.out.println("Wrong options!");
                    scanner.next();
                    choice = -1;
                }
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter a new name for the salad: ");
                        setNewNameSalad();
                        System.out.printf("\nNew salad name: %s", salad.getName());
                    }
                    case 2 -> salad.showRecipe();
                    case 3 -> choiceOfIngredients();
                    case 4 -> salad.sortedIngredientsByCalories();
                    case 5 -> salad.sortedIngredientsByWeight();
                    case 6 -> salad.sortedIngredientsByName();
                    case 7 -> showIngredientsForCalories(scanner);
                    default -> showOfIngredients();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setNewNameSalad() {
        try (Scanner scanner = new Scanner(System.in)) {
            String newName = scanner.nextLine();
            salad.setName(newName);
            additionalOptions();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showIngredientsForCalories(Scanner scanner) {
        double underCalories = 0.0;
        double upperCalories = 0.0;
        try {
            System.out.println("Enter the lower limit: ");
            underCalories = scanner.nextDouble();
            System.out.println("Enter the upper limit: ");
            upperCalories = scanner.nextDouble();
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong input!");
            scanner.next();
        }
        salad.showIngredientsInCalorieRange(underCalories, upperCalories);
    }

    private void showOfIngredients() {
        System.out.println("Ingredients for your salad: ");
        salad.showRecipe();
    }

    private void choiceOfIngredients() {
        int choice = -1;
        Vegetable vegetable;
        try (Scanner scanner = new Scanner(System.in)) {
            while (choice != 0) {
                System.out.println("\nSelect the ingredient number and weight : ");
                System.out.println("1. Carrot");
                System.out.println("2. Cucumber");
                System.out.println("3. Lettuce");
                System.out.println("4. Onion");
                System.out.println("5. Potato");
                System.out.println("6. Tomato");
                System.out.println("7. White Cabbage");
                System.out.println("Press 0 to exit.");
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("This number is not in the list");
                    scanner.next();
                    choice = -1;
                }
                switch (choice) {
                    case 1 -> {
                        vegetable = new Carrot(scanner.nextInt());
                        salad.addIngredient(vegetable);
                    }
                    case 2 -> {
                        vegetable = new Cucumber(scanner.nextInt());
                        salad.addIngredient(vegetable);
                    }
                    case 3 -> {
                        vegetable = new Lettuce(scanner.nextInt());
                        salad.addIngredient(vegetable);
                    }
                    case 4 -> {
                        vegetable = new Onion(scanner.nextInt());
                        salad.addIngredient(vegetable);
                    }
                    case 5 -> {
                        vegetable = new Potato(scanner.nextInt());
                        salad.addIngredient(vegetable);
                    }
                    case 6 -> {
                        vegetable = new Tomato(scanner.nextInt());
                        salad.addIngredient(vegetable);
                    }
                    case 7 -> {
                        vegetable = new WhiteCabbage(scanner.nextInt());
                        salad.addIngredient(vegetable);
                    }
                    default -> {
                        showOfIngredients();
                        additionalOptions();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
