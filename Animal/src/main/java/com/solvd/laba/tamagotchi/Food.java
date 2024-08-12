package com.solvd.laba.tamagotchi;

public enum Food {
    MEAT(2),
    FISH(2),
    MILK(1),
    CRISPS(1),
    SEEDS(1),
    FRUIT(1),
    VEGETABLES(1),
    GRASS(1);

    private final int satisfactionLevel;

    Food(int satisfactionLevel) {
        this.satisfactionLevel = satisfactionLevel;
    }

    public int getSatisfactionLevel() {
        return satisfactionLevel;
    }
}

