package com.solvd.laba.tamagotchi;

import java.util.Objects;
import java.util.Scanner;

public class Rabbit extends Pet {

    public Rabbit(String name, String breed, String color) {
        super(name, breed, color);
    }

    @Override
    public void greetOwner(boolean isPetKnowOwner) {
        if (!isPetKnowOwner) {
            System.out.println("Nibbles! I'm so happy to be your pet!");
            System.out.println("I love to eat: " + getFavoriteFood());
            System.out.print("What will you name me? ");

            Scanner scanner = new Scanner(System.in);
            String newName = scanner.nextLine();
            setName(newName);

            System.out.println(newName + "! What a cute rabbit name!!! It's delightful!");
        } else {
            System.out.println(name + ": - Nibbles! I love my owner! It's wonderful to see you again!");
        }
    }

    @Override
    public void tick() {
        hungerLevel += 4;
    }

    @Override
    public boolean likesFood(Food food) {
        return food == Food.VEGETABLES || food == Food.GRASS;
    }

    @Override
    public String getFavoriteFood() {
        return "vegetables, grass";
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
