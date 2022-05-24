package chef.vegetableCrops;

public abstract class LettuceVegetables extends Vegetable{
    public LettuceVegetables(String name, double weight, double calories) {
        super(name, weight, calories);
        setVegetableCrops("salad lettuce vegetables");
    }
}
