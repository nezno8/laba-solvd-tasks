package com.solvd.laba.tamagotchi.interfaces;

import com.solvd.laba.tamagotchi.Food;
import com.solvd.laba.tamagotchi.Pet;

@FunctionalInterface
public
interface IFeedPet<T extends Pet> {
    void feed(T pet, Food food);
}
