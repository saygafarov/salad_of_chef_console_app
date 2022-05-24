package chef.vegetableCrops;

public abstract class RootsVegetables extends Vegetable {
    public RootsVegetables(String name, double weight, double calories) {
        super(name, weight, calories);
        setVegetableCrops("roots vegetables");
    }
}
