package com.solvd.laba.tamagotchi;

import java.util.Scanner;

public class Dog extends Pet {

    public Dog(String name, String breed, String color) {
        super(name, breed, color);
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
        } else {
            System.out.println(name + ": - Woof! I love my owner!  I'm so happy to see you again!");
        }
    }

    @Override
    public void tick() {
        hungerLevel++;
        calculateHealthLevel();
    }

    @Override
    public boolean likesFood(Food food) {
        return food == Food.MEAT || food == Food.CRISPS;
    }

    @Override
    public String getFavoriteFood() {
        return "meat, treats";
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                ", hungerLevel=" + hungerLevel +
                ", healthLevel=" + healthLevel +
                ", isActive=" + isActive +
                ", isSick=" + isSick +
                '}';
    }
}
