package com.solvd.laba.tamagotchi;

import java.util.*;

public class PetManager {
    private Map<String, PetOwner> petOwners;

    public PetManager() {
        petOwners = new HashMap<>();
    }

    public void addOwner(String username) {
        if (!petOwners.containsKey(username)) {
            petOwners.put(username, new PetOwner(username));
            System.out.println("Added new pet owner: " + username);
        } else {
            System.out.println("Username " + username + " already exists.");
        }
    }

    public PetOwner getOwner(String username) {
        return petOwners.get(username);
    }

    public void choosePetForOwner(String username, String petName) {
        PetOwner owner = petOwners.get(username);
        if (owner != null) {
            owner.choose(petName);
        } else {
            System.out.println("No owner found with the username: " + username);
        }
    }

    public void choosePetOwner(String username) {
        PetOwner owner = petOwners.get(username);
        if (owner != null) {
            System.out.println("Selected pet owner: " + username);
        } else {
            System.out.println("No owner found with the username: " + username);
        }
    }

    public StringBuilder printAllOwners() {
        StringBuilder result = new StringBuilder("\n");
        for (Map.Entry<String, PetOwner> entry : petOwners.entrySet()) {
            String username = entry.getKey();
            PetOwner owner = entry.getValue();
            result.append("Username: ").append(username).append(" --> Pets:");
            if (owner.getPets().isEmpty()) {
                result.append(" []");
        }  else {
                for (Pet pet : owner.getPets()) {
                    result.append(" \n| ").append(pet.toString()).append(" | ");
                }
            }
            result.append("\n");
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PetManager)) return false;
        PetManager that = (PetManager) o;
        return Objects.equals(petOwners, that.petOwners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petOwners);
    }

    @Override
    public String toString() {
        return "System Manager have got information about " + getOwnerCount() + " pet owners:"
                + this.printAllOwners();
    }

    private Integer getOwnerCount() {
        return petOwners != null ? petOwners.size() : 0;
    }
}
