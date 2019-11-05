

import wildFarm.foods.*;
import wildFarm.animals.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] animalTokens = input.split("\\s+");

            String[] foodTokens = scanner.nextLine().split("\\s+");

            Animal animal = produceAnimal(animalTokens);

            Food food = produceFood(foodTokens);

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            animals.add(animal);
            input = scanner.nextLine();
        }
        animals.forEach(animal -> System.out.println(animal.toString()));

    }

    private static Food produceFood(String[] foodTokens) {
        String type = foodTokens[0];

        Food food = null;
        try {
            Class foodClass = Class.forName("wildFarm.foods." + type);
            Constructor constructor = foodClass.getConstructor(int.class);
            food = (Food) constructor.newInstance(Integer.parseInt(foodTokens[1]));
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return food;
    }

    private static Animal produceAnimal(String[] animalTokens) {
        Animal animal = null;
        String type = animalTokens[0];
        if (type.equals("Mouse")) {
            animal = new Mouse(animalTokens[1]
                    , animalTokens[0]
                    , Double.parseDouble(animalTokens[2])
                    , animalTokens[3]
            );
        } else if (type.equals("Zebra")) {
            animal = new Zebra(animalTokens[1]
                    , animalTokens[0]
                    , Double.parseDouble(animalTokens[2])
                    , animalTokens[3]
            );
        } else if (type.equals("Cat")) {
            animal = new Cat(animalTokens[1]
                    , animalTokens[0]
                    , Double.parseDouble(animalTokens[2])
                    , animalTokens[3]
                    , animalTokens[4]);

        } else if (type.equals("Tiger")) {
            animal = new Tiger(animalTokens[1]
                    , animalTokens[0]
                    , Double.parseDouble(animalTokens[2])
                    , animalTokens[3]
            );
        }

        return animal;
    }

}
