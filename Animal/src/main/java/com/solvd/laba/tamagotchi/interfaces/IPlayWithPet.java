package com.solvd.laba.tamagotchi.interfaces;

import com.solvd.laba.tamagotchi.Pet;

@FunctionalInterface
public
interface IPlayWithPet<T extends Pet> {
    void play(T pet);
}
