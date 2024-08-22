package com.solvd.laba.tamagotchi;

import java.util.Objects;

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
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return hungerLevel == pet.hungerLevel && healthLevel == pet.healthLevel && isActive == pet.isActive && isSick == pet.isSick && Objects.equals(name, pet.name) && Objects.equals(breed, pet.breed) && Objects.equals(color, pet.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, breed, color, hungerLevel, healthLevel, isActive, isSick);
    }

    @Override
    public String toString() {
        return "Pet{" +
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

