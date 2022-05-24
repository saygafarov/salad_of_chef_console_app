package chef.vegetableCrops;

public abstract class CabbageVegetables extends Vegetable {
    public CabbageVegetables(String name, double weight, double calories) {
        super(name, weight, calories);
        setVegetableCrops("cabbage vegetables");
    }
}
