package com.solvd.laba.tamagotchi;

import com.solvd.laba.tamagotchi.interfaces.AdoptPet;
import com.solvd.laba.tamagotchi.interfaces.ChoosePet;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PetOwner implements AdoptPet, ChoosePet {

    private String username;
    private Set<Pet> pets;
    private Pet selectedPet;

    public PetOwner(String username) {
        this.username = username;
        this.pets = new HashSet<>();
        this.selectedPet = null;
    }

    @Override
    public void adopt(Pet pet) {
        if (pets.contains(pet)) {
            System.out.println(username + " already has a " + pet.getClass().getSimpleName() + " named " + pet.getName() + ".");
            pet.greetOwner(true);
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

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Pet getSelectedPet() {
        return selectedPet;
    }

    public void setSelectedPet(Pet selectedPet) {
        this.selectedPet = selectedPet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PetOwner petOwner)) return false;
        boolean areEqual = Objects.equals(username, petOwner.username);
        System.out.println("PetOwner " + this.getUsername() + ": hashCode " + this.hashCode() + " and object PetOwner " + ((PetOwner) o).getUsername() + ": hashCode " + ((PetOwner) o).hashCode() + " equality result: " + areEqual);
        return areEqual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "Pet owner " + username +
                " have pets: " + pets;
    }
}
