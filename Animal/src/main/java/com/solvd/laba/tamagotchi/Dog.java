package com.solvd.laba.tamagotchi;

public class Dog extends Pet {
    private String breed;
    private String color;

    public Dog(String name, String breed, String color) {
        super(name);
        this.breed = breed;
        this.color = color;
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
}
