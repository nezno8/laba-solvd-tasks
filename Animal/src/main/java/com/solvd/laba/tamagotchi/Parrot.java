package com.solvd.laba.tamagotchi;

import java.util.Scanner;

public class Parrot extends Pet {

    public Parrot(String name, String breed, String color) {
        super(name, breed, color);
    }

    @Override
    public void greetOwner(boolean isPetKnowOwner) {
        if (!isPetKnowOwner) {
            System.out.println("Squawk! I'm thrilled to be your pet!");
            System.out.println("I love to eat: " + getFavoriteFood());
            System.out.print("What will you name me? ");

            Scanner scanner = new Scanner(System.in);
            String newName = scanner.nextLine();
            setName(newName);

            System.out.println(newName + "! What a colorful parrot name!!! It's amazing!");
        } else {
            System.out.println(name + ": - Squawk! I love my owner! It's great to see you again!");
        }
    }

    @Override
    public void tick() {
        hungerLevel += 3;
        calculateHealthLevel();
    }

    @Override
    public boolean likesFood(Food food) {
        return food == Food.SEEDS || food == Food.FRUIT;
    }

    @Override
    public String getFavoriteFood() {
        return "seeds, fruits";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " named " + name;
    }

    public String toStringDetailed() {
        return super.toString();
    }

    public BodyCovering getBodyCovering() {
        return BodyCovering.FEATHERS;
    }
}
