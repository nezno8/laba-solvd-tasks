package com.solvd.laba.tamagotchi;

import java.util.ArrayList;
import java.util.List;

import static com.solvd.laba.tamagotchi.Pet.doesAnimalLikeMeet;

public class Main {
    public static void main(String[] args) {

        System.out.println("____________________________________________________________________");
        Pet petDog = new Dog("Buddy", "Labrador", "brown");
        Pet petDogPuppy = new Dog("Buddy", "Labrador", "brown");

        System.out.println("petDog.equals(petDogPuppy): " + petDog.equals(petDogPuppy));
        System.out.println("petDog.hashCode(): " + petDog.hashCode());
        System.out.println("petDogPuppy.hashCode(): " + petDogPuppy.hashCode());
        System.out.println("____________________________________________________________________");

        PetManager petManager = new PetManager();
        System.out.println(petManager);
        System.out.println(new PetOwner("Jii"));

        System.out.printf("%-20S%n", "_".repeat(10) + "Created_Owners:" + "_".repeat(10));

        petManager.addOwner("John");
        PetOwner john = petManager.getOwner("John");

        petManager.addOwner("Alice");
        PetOwner alice = petManager.getOwner("Alice");

        System.out.println(petManager);

        System.out.printf("%-20S%n", "_".repeat(10) + "All_information_in_manager:" + "_".repeat(10));
        System.out.println(petManager);
        System.out.printf("%-20s%n","_".repeat(35));

        System.out.printf("%-20S%n", "_".repeat(10) + "Adopting_Pet:" + "_".repeat(10));
        petManager.getOwner("John");
        john.adopt(new Cat("Sunny", "Siamese", "brown"));
        System.out.println("\n");
        john.adopt(new Dog("Buddy", "Labrador", "black"));
        System.out.printf("%-20s%n","_".repeat(35));

        System.out.println(petManager);

        System.out.printf("%-20S%n", "_".repeat(10) + "Choose_Pet:" + "_".repeat(10));
        petManager.choosePetForOwner("John", "Sunny");
        //TODO: Printing 2times --> need refactor this method
        System.out.println("\n");
        petManager.choosePetForOwner("John", "Sunny");
        System.out.printf("%-20s%n","_".repeat(35));

        System.out.printf("%-20S%n", "_".repeat(10) + "All_Pets_and_Owners:" + "_".repeat(10));
        petManager.printAllOwners();
        System.out.printf("%-20s%n","_".repeat(35));

        List<Pet> animals = new ArrayList<>();
        animals.add(new Dog("Azor", "Labrador", "Black"));
        animals.add(new Cat("Sara", "Siamese", "White"));
        animals.add(new Parrot("Koko", "African Red Parrot", "Red"));
        animals.add(new Rabbit("Bunny", "Holland Lop", "Grey"));

        System.out.printf("%-20s%n","_".repeat(35));
        System.out.println("Does this animal eat meat?");
        for (Pet pet : animals) {
            System.out.println(pet.getName()
                    + " is a " + pet.getClass().getSimpleName()
                    + " and " + pet.getClass().getSimpleName()
                    + "s" + (doesAnimalLikeMeet(pet) ? " eat meet." : " do not eat meet."));
        }
        System.out.printf("%-20s%n","_".repeat(35));
        System.out.println("\n");

        System.out.println(new Cat("Sunny", "Siamese", "Brown").toStringDetailed());
        System.out.println(new Dog("Azor", "Labrador", "Black"));
        System.out.println(new Parrot("Koko", "African Red Parrot", "Red").toStringDetailed());
        System.out.println(new Rabbit("Bunny", "Holland Lop", "Grey"));

        //TODO: Change the pet adoption and selection mechanism:
        // - by adding a second constructor for Pet without a name or see a separate Animal or PetShop class,
        // - split the Owner greeting mechanism
        // - refactor connection between PetOwner and PetManager --> maybe pattern Factory or Builder
        // - builder for create pet


        System.out.printf("%-20s%n","_".repeat(35));
        System.out.println("\nAnimal hunger levels and health levels before time passage:");
        for (Pet pet : animals) {
            System.out.println(pet.getName() + ": Hunger Level = " + pet.getHungerLevel() + ", Health Level = " + pet.getHealthLevel());
        }

        for (Pet pet : animals) {
            pet.tick();
            pet.calculateHealthLevel();
        }

        System.out.println("\nAnimal hunger levels and health levels after time passage:");
        for (Pet pet : animals) {
            System.out.println(pet.getName() + ": Hunger Level = " + pet.getHungerLevel() + ", Health Level = " + pet.getHealthLevel());
        }

        System.out.println("\nFeeding animals...");

        petManager.choosePetForOwner("John", "Buddy");


        System.out.println("\n" + john.getUsername() + " want choose a pet:");
        john.choose("Sunny");
        john.feedSelectedPet(Food.FISH);

        System.out.println("\nAnimal hunger levels and health levels after feeding:");
        for (Pet pet : animals) {
            System.out.println(pet.getName() + ": Hunger Level = " + pet.getHungerLevel() + ", Health Level = " + pet.getHealthLevel() + ", Is Sick: " + pet.isSick());
        }

        System.out.println("\nPlaying with pets...");
        john.choose("Sunny");
        john.playWithSelectedPet();
        john.choose("Buddy");
        john.playWithSelectedPet();

        System.out.println("\nAnimal hunger levels and health levels after playing:");
        for (Pet pet : animals) {
            System.out.println(pet.getName() + ": Hunger Level = " + pet.getHungerLevel() + ", Health Level = " + pet.getHealthLevel() + ", Is Sick: " + pet.isSick());
        }
    }
}

