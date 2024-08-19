package com.solvd.laba.tamagotchi;

import java.util.ArrayList;
import java.util.List;

import static com.solvd.laba.tamagotchi.Pet.doesAnimalLikeMeet;

public class Main {
    public static void main(String[] args) {

        List<Pet> animals = new ArrayList<>();
        animals.add(new Dog("Azor", "Labrador", "Black"));
        animals.add(new Cat("Sunny", "Siamese", "White"));
        animals.add(new Parrot("Koko", "African Red Parrot", "Red"));
        animals.add(new Rabbit("Bunny", "Holland Lop", "Grey"));

        System.out.println("Does this animal eat meat?");
        for (Pet pet : animals) {
            System.out.println(pet.getName()
                    + " is a " + pet.getClass().getSimpleName()
                    + " and " + pet.getClass().getSimpleName()
                    + "s" + (doesAnimalLikeMeet(pet) ? " eat meet." : " do not eat meet."));
        }

        PetOwner owner = new PetOwner("Alice");

        //TODO: Change the pet adoption and selection mechanism:
        // - by adding a second constructor for Pet without a name or see a separate Animal or PetShop class,
        // - split the Owner greeting mechanism

        System.out.println("\n" + owner.getUsername() + " want adopting a pet:");
        owner.adopt(animals.get(0));

        System.out.println("\n" + owner.getUsername() + " want adopting a pet:");
        owner.adopt(animals.get(1));

        System.out.println("\n" + owner.getUsername() + " choose pet:");
        owner.choose(animals.get(0));
        owner.feedSelectedPet(Food.FISH);
        owner.playWithSelectedPet();
        owner.takeSelectedPetToVet();

        System.out.println("\n" + owner.getUsername() + " choose pet:");
        owner.choose(animals.get(1));
        owner.feedSelectedPet(Food.MEAT);
        owner.playWithSelectedPet();
        owner.takeSelectedPetToVet();

        System.out.println("\nAnimal hunger levels before time passage:");
        System.out.println("Dog: " + animals.get(0).getHungerLevel());
        System.out.println("Cat: " + animals.get(1).getHungerLevel());
        System.out.println("Parrot: " + animals.get(2).getHungerLevel());
        System.out.println("Rabbit: " + animals.get(3).getHungerLevel());

        animals.get(0).tick();
        animals.get(1).tick();
        animals.get(2).tick();
        animals.get(3).tick();

        System.out.println("\nAnimal hunger levels after time passage:");
        System.out.println("Dog: " + animals.get(0).getHungerLevel());
        System.out.println("Cat: " + animals.get(1).getHungerLevel());
        System.out.println("Parrot: " + animals.get(2).getHungerLevel());
        System.out.println("Rabbit: " + animals.get(3).getHungerLevel());

        animals.get(0).eat(Food.CRISPS);
        animals.get(1).eat(Food.FISH);
        animals.get(2).eat(Food.FRUIT);
        animals.get(3).eat(Food.VEGETABLES);

        System.out.println("\nAnimal hunger levels after feeding in the morning: ");
        System.out.println("Dog: " + animals.get(0).getHungerLevel());
        System.out.println("Cat: " + animals.get(1).getHungerLevel());
        System.out.println("Parrot: " + animals.get(2).getHungerLevel());
        System.out.println("Rabbit: " + animals.get(3).getHungerLevel());

        animals.get(0).eat(Food.CRISPS);
        animals.get(1).eat(Food.FISH);
        animals.get(2).eat(Food.FRUIT);
        animals.get(3).eat(Food.VEGETABLES);

        System.out.println("\nAnimal hunger levels after evening feeding");
        System.out.println("Dog: " + animals.get(0).getHungerLevel());
        System.out.println("Cat: " + animals.get(1).getHungerLevel());
        System.out.println("Parrot: " + animals.get(2).getHungerLevel());
        System.out.println("Rabbit: " + animals.get(3).getHungerLevel());
    }
}

