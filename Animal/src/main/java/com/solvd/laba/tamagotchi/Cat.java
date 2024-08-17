package com.solvd.laba.tamagotchi;

import java.util.Scanner;

public class Cat extends Pet {
    private String breed;
    private String color;

    public Cat(String name, String breed, String color) {
        super(name);
        this.breed = breed;
        this.color = color;
    }

    @Override
    public void greetOwner(boolean isPetKnowOwner) {
        if (isPetKnowOwner) {
            System.out.println("Meow! I'm so happy to be your pet!");
            System.out.println("I like to eat: " + getFavoriteFood());
            System.out.print("What will you name me? ");

            Scanner scanner = new Scanner(System.in);
            String newName = scanner.nextLine();
            setName(newName);

            System.out.println(newName + "! What a purring cat name!!! It's wonderful!");
        }
        System.out.println(name + ": - Meow! I love my owner! I'm so glad to see you again!");
    }

    @Override
    public void tick() {
        hungerLevel += 2;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean likesFood(Food food) {
        return food == Food.FISH || food == Food.MILK;
    }

    @Override
    public String getFavoriteFood() {
        return "fish, milk";
    }
}
