package com.solvd.laba.tamagotchi;

import java.util.Scanner;

public class Dog extends Pet {
    private BodyCovering bodyCovering;
    public Dog(String name, String breed, String color) {
        super(name, breed, color);
        this.bodyCovering = BodyCovering.FUR;
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
        return "__________________________________________________________________________________________________________________________________\n"
                + "Hello!\n"
                + "I am a " + this.getClass().getSimpleName().toLowerCase()
                + " and I would like to tell you my story: \n"
                + "Everyone calls me " + name
                + ", and my breed is " + breed + ". \n"
                + "My " + bodyCovering.getDescription() + " have " + color.toLowerCase()
                + " color, which makes me really special! \n"
                + "Sometimes I feel hungry, how about YOU? \n"
                + "My hunger level right now is: " + hungerLevel + "\n"
                + "When it's time for a tasty snack, I dream about: " + this.getFavoriteFood() +  ".\n"
                + "I long for an owner who will take care of my health and won't feed me products that make me sick. \n"
                + "So please remember what I enjoy eating: " + this.getFavoriteFood() + ".\n"
                + "Take care of mine health too, because I can lose it if I eat poorly or lead a sedentary lifestyle! \n"
                + "I am healthy at " + healthLevel + "%, but if I get sick, YOU should visit the veterinarian with me. \n"
                + "He will tell you today that " + (isSick ? "I am sick.\n" : "I am not sick.\n")
                + "I run, jump, and play - this is what my life as a " + this.getClass().getSimpleName().toLowerCase() + " looks like – full of joy, adventures, and lots of love! \n"
                + "__________________________________________________________________________________________________________________________________";
    }
}
