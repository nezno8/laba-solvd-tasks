package com.solvd.laba.tamagotchi;

import java.util.Scanner;

public class Cat extends Pet {
    public Cat(String name, String breed, String color) {
        super(name, breed, color);
    }

    @Override
    public void greetOwner(boolean isPetKnowOwner) {
        if (!isPetKnowOwner) {
            System.out.println("Meow! I'm so happy to be your pet!");
            System.out.println("I like to eat: " + getFavoriteFood());
            System.out.print("What will you name me? ");

            Scanner scanner = new Scanner(System.in);
            String newName = scanner.nextLine();
            setName(newName);

            System.out.println(newName + "! What a purring cat name!!! It's wonderful!");
        } else {
            System.out.println(name + ": - Meow! I love my owner! I'm so glad to see you again!");
        }
    }

    @Override
    public void tick() {

        hungerLevel += 2;
        calculateHealthLevel();
    }

    @Override
    public boolean likesFood(Food food) {
        return food == Food.FISH || food == Food.MILK;
    }

    @Override
    public String getFavoriteFood() {
        return "fish, milk";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " named " + name;
    }

    public String toStringDetailed() {
        return super.toString();
    }

    public BodyCovering getBodyCovering() {
        return BodyCovering.FUR;
    }
}
