package com.solvd.laba.tamagotchi;

public class Cat extends Pet {
    private String breed;
    private String color;

    public Cat(String name, String breed, String color) {
        super(name);
        this.breed = breed;
        this.color = color;
    }

    @Override
    public void tick() {
        hungerLevel += 2;
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
        return food == Food.FISH || food == Food.MILK;
    }
}
