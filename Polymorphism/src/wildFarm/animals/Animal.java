package wildFarm.animals;

import wildFarm.foods.Food;

import java.text.DecimalFormat;

public abstract class Animal {

    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    public Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public String getAnimalType() {
        return animalType;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        return
                String.format("%s[%s, %s, region, %d]",
                        this.animalType,
                        this.animalName,
                        decimalFormat.format(this.animalWeight),
                        this.foodEaten
                );
    }
}
