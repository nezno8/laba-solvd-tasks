package com.solvd.laba.tamagotchi;

@FunctionalInterface
interface ITeachTrick<T extends Pet> {
    void teachTrick(T pet, String trick);
}
