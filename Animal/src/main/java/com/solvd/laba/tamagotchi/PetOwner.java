package com.solvd.laba.tamagotchi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        if (pets.contains(pet)) {
            System.out.println(username + " already has a " + pet.getClass().getSimpleName() + " named " + pet.getName() + ".");
            pet.greetOwner(true);
            return;
        } else {
                pets.add(pet);
                System.out.println(username + " adopted a new pet: " + pet.getName());
                pet.greetOwner(false);
            }
    }

    @Override
    public void choose(String petName) {
        for (Pet existingPet : pets) {
            if (existingPet.getName().equalsIgnoreCase(petName)) {
                selectedPet = existingPet;
                System.out.println(username + " selected " + existingPet.getName() + " as their pet.");
                existingPet.greetOwner(true);
                return;
            } else {
                System.out.println(username + " doesn't own a pet named " + petName + ".");
            }
        }
    }

    public void feedSelectedPet(Food food) {
        if (selectedPet != null) {
            System.out.println("\n" + username + " feeds own pet with " + food.name() + ".");
            selectedPet.eat(food);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PetOwner)) return false;
        PetOwner petOwner = (PetOwner) o;
        return Objects.equals(username, petOwner.username) && Objects.equals(pets, petOwner.pets) && Objects.equals(selectedPet, petOwner.selectedPet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, pets, selectedPet);
    }

    @Override
    public String toString() {
        return "PetOwner{" +
                "username='" + username + '\'' +
                ", pets=" + pets +
                ", selectedPet=" + selectedPet +
                '}';
    }
}
