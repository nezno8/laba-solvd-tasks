package com.solvd.laba.tamagotchi;

import java.util.ArrayList;
import java.util.List;

public class PetOwner implements AdoptPet, ChoosePet {
    private String username;
    private List<Pet> pets;
    private Pet selectedPet;

    public PetOwner(String username) {
        this.username = username;
        this.pets = new ArrayList<>();
        this.selectedPet = null;
    }

    @Override
    public void adopt(Pet pet) {
        for (Pet existingPet : pets) {
            if (existingPet.getClass() == pet.getClass() && existingPet.getName().equals(pet.getName())) {
                System.out.println(username + " already has a " + pet.getClass().getSimpleName() + " named " + existingPet.getName() + ".");
                pet.greetOwner(true);
                return;
            }
        }
        pets.add(pet);
        System.out.println(username + " adopted a new pet: " + pet.getName());
        pet.greetOwner(false);
    }

    @Override
    public void choose(Pet pet) {
        if (pets.contains(pet)) {
            selectedPet = pet;
            System.out.println(username + " selected " + pet.getName() + " as their pet.");
            pet.greetOwner(true);
        } else {
            System.out.println(username + " doesn't own this pet.");
        }
    }

    public void feedSelectedPet(Food food) {
        if (selectedPet != null) {
            selectedPet.eat(food);
            System.out.println(username + " fed " + selectedPet.getName() + " with " + food);
        } else {
            System.out.println(username + " doesn't have a selected pet to feed.");
        }
    }

    public void playWithSelectedPet() {
        if (selectedPet != null) {
            System.out.println(username + " is playing with " + selectedPet.getName());
        } else {
            System.out.println(username + " doesn't have a selected pet to play with.");
        }
    }

    public void takeSelectedPetToVet() {
        if (selectedPet != null) {
            System.out.println(username + " is taking " + selectedPet.getName() + " to the vet.");
        } else {
            System.out.println(username + " doesn't have a selected pet to take to the vet.");
        }
    }

    public String getUsername() {
        return username;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public Pet getSelectedPet() {
        return selectedPet;
    }
}
