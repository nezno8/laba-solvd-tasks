package com.solvd.laba.tamagotchi;

@FunctionalInterface
interface IFeedPet<T extends Pet> {
    void feed(T pet, Food food);
}
