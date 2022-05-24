package chef.vegetableCrops;

public abstract class TomatoVegetables extends Vegetable {
    public TomatoVegetables(String name, double weight, double calories) {
        super(name, weight, calories);
        setVegetableCrops("tomato");
    }
}
