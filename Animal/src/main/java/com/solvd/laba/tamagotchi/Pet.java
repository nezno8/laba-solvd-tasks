package com.solvd.laba.tamagotchi;

public abstract class Pet {
    protected int hungerLevel;
    protected String name;

    public Pet(String name) {
        this.name = name;
        this.hungerLevel = 0;
    }

    public abstract void greetOwner(boolean isPetKnowOwner);

    public abstract void tick();

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void eat(Food food) {
        if (likesFood(food)) {
            hungerLevel = Math.max(0, hungerLevel - food.getSatisfactionLevel());
        }
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

    public abstract boolean likesFood(Food food);

    public abstract String getFavoriteFood();

    public static boolean doesAnimalLikeMeet(Pet pet) {
        return pet.likesFood(Food.MEAT);
    }
}

