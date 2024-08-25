package com.solvd.laba.tamagotchi;

import java.util.Objects;
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

    //    public String toString() {
//        return "__________________________________________________________________________________________________________________________________\n"
//                + "Hello!\n"
//                + "I am a " + this.getClass().getSimpleName().toLowerCase()
//                + " and I would like to tell you my story: \n"
//                + "Everyone calls me " + name
//                + ", and my breed is " + breed + ". \n"
//                + "My " + bodyCovering.getDescription() + " have " + color.toLowerCase()
//                + " color, which makes me really special! \n"
//                + "Sometimes I feel hungry, how about YOU? \n"
//                + "My hunger level right now is: " + hungerLevel + "\n"
//                + "When it's time for a tasty snack, I dream about: " + this.getFavoriteFood() +  ".\n"
//                + "I long for an owner who will take care of my health and won't feed me products that make me sick. \n"
//                + "So please remember what I enjoy eating: " + this.getFavoriteFood() + ".\n"
//                + "Take care of mine health too, because I can lose it if I eat poorly or lead a sedentary lifestyle! \n"
//                + "I am healthy at " + healthLevel + "%, but if I get sick, YOU should visit the veterinarian with me. \n"
//                + "He will tell you today that " + (isSick ? "I am sick.\n" : "I am not sick.\n")
//                + "I run, jump, and play - this is what my life as a " + this.getClass().getSimpleName().toLowerCase() + " looks like – full of joy, adventures, and lots of love! \n"
//                + "__________________________________________________________________________________________________________________________________";
//    }
}
