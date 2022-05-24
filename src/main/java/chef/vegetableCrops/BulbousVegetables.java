package chef.vegetableCrops;

public abstract class BulbousVegetables extends Vegetable{
    public BulbousVegetables(String name, double weight, double calories) {
        super(name, weight, calories);
        setVegetableCrops("bulbous vegetables");
    }
}
