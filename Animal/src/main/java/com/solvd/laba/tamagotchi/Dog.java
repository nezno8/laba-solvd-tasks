package com.solvd.laba.tamagotchi;

import java.util.Scanner;

public class Dog extends Pet {
    private String breed;
    private String color;

    public Dog(String name, String breed, String color) {
        super(name);
        this.breed = breed;
        this.color = color;
    }

    @Override
    public void greetOwner(boolean isPetKnowOwner) {
        if (!isPetKnowOwner) {
            System.out.println("Woof! I'm so excited to be your pet!");
            System.out.println("I love to eat: " + getFavoriteFood());
            System.out.print("What will you name me? ");

            Scanner scanner = new Scanner(System.in);
            String newName = scanner.nextLine();
            setName(newName);

            System.out.println(newName + "! What a fantastic dog name!!! It's wonderful!");
        }
        System.out.println("Woof! My name is " + getName() + "! I'm so happy to see you again!");
    }

    @Override
    public void tick() {
        hungerLevel++;
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
        return food == Food.MEAT || food == Food.CRISPS;
    }

    @Override
    public String getFavoriteFood() {
        return "meat, treats";
    }
}
