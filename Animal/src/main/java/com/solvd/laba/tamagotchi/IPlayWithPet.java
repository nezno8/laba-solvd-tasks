package com.solvd.laba.tamagotchi;

@FunctionalInterface
interface IPlayWithPet<T extends Pet> {
    void play(T pet);
}
