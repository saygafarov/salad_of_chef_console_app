package chef.vegetableCrops;

public abstract class TubersVegetables extends Vegetable {

    public TubersVegetables(String name, double weight, double calories) {
        super(name, weight, calories);
        setVegetableCrops("Tubers vegetables");
    }
}
