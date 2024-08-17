package com.solvd.laba.tamagotchi;

import java.util.Scanner;

public class Parrot extends Pet {
    private String breed;
    private String color;

    public Parrot(String name, String breed, String color) {
        super(name);
        this.breed = breed;
        this.color = color;
    }

    @Override
    public void greetOwner(boolean isPetKnowOwner) {
        if (isPetKnowOwner) {
            System.out.println("Squawk! I'm thrilled to be your pet!");
            System.out.println("I love to eat: " + getFavoriteFood());
            System.out.print("What will you name me? ");

            Scanner scanner = new Scanner(System.in);
            String newName = scanner.nextLine();
            setName(newName);

            System.out.println(newName + "! What a colorful parrot name!!! It's amazing!");
        }
        System.out.println("Squawk! My name is " + getName() + "! It's great to see you again!");
    }

    @Override
    public void tick() {
        hungerLevel+= 3;
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
        return food == Food.SEEDS || food == Food.FRUIT;
    }

    @Override
    public String getFavoriteFood() {
        return "seeds, fruits";
    }
}
