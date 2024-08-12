package com.solvd.laba.tamagotchi;

import org.junit.Before;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class PetTest {
    protected Pet pet;
    protected abstract Pet createPet(String name);

    @Before
    public void setUp() {
        pet = createPet("Test to Pet");
    }

    protected void checkHunger(int expectedHunger) {
        assertEquals(expectedHunger, pet.getHungerLevel());
    }

    protected void feedPet(Food food) {
        pet.eat(food);
    }

}
