package com.solvd.laba.tamagotchi.interfaces;

import com.solvd.laba.tamagotchi.Pet;

@FunctionalInterface
public
interface ITeachTrick<T extends Pet> {
    void teachTrick(T pet, String trick);
}
