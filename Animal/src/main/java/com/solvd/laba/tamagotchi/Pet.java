package com.solvd.laba.tamagotchi;

import java.util.Objects;
import java.util.regex.PatternSyntaxException;

public abstract class Pet {

    protected String name;

    protected String breed;

    protected String color;

    protected int hungerLevel;

    protected int healthLevel;

    protected boolean isActive;
    protected boolean isSick;

    //TODO How do that: first name be always Dog, Cat ...
    // then we check if this object is instance.of that class and user must change the name
    protected Pet(String name, String breed, String color) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.hungerLevel = 0;
        this.healthLevel = 100;
        this.isActive = true;
        this.isSick = false;
    }

    public static boolean doesAnimalLikeMeet(Pet pet) {
        return pet.likesFood(Food.MEAT);
    }

    public abstract boolean likesFood(Food food);

    public abstract void greetOwner(boolean isPetKnowOwner);

    public abstract BodyCovering getBodyCovering();

    public abstract void tick();

    protected void calculateHealthLevel() {

        if (hungerLevel > 50) {
            healthLevel -= 10;
        } else {
            healthLevel += 5;
        }

        if (isActive) {
            healthLevel += 5;
        } else {
            healthLevel -= 5;
        }

        if (isSick) {
            healthLevel -= 20;
        }

        healthLevel = Math.max(0, Math.min(100, healthLevel));
    }

    public void eat(Food food) {
        if (likesFood(food)) {
            hungerLevel = Math.max(0, hungerLevel - food.getSatisfactionLevel());
            isSick = false;
        } else {
            hungerLevel += food.getSatisfactionLevel();
            isSick = true;
            System.out.println(name + " does not like " + food + " and is now sick!");
        }
    }

    public abstract String getFavoriteFood();

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isSick() {
        return isSick;
    }

    public void setSick(boolean sick) {
        isSick = sick;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals()");
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return hungerLevel == pet.hungerLevel && healthLevel == pet.healthLevel && isActive == pet.isActive && isSick == pet.isSick && Objects.equals(name, pet.name) && Objects.equals(breed, pet.breed) && Objects.equals(color, pet.color);
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode");
        return Objects.hash(name, breed, color, hungerLevel, healthLevel, isActive, isSick);
    }

    @Override
    public String toString() {
        return "__________________________________________________________________________________________________________________________________\n"
                + "Hello!\n"
                + "I am a " + this.getClass().getSimpleName().toLowerCase()
                + " and I would like to tell you my story: \n"
                + "Everyone calls me " + name
                + ", and my breed is " + breed + ". \n"
                + "My " + this.getBodyCovering().getDescription() + " have " + color.toLowerCase()
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

