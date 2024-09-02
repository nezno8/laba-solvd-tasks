package com.solvd.laba.tamagotchi;

import java.util.*;

public class PetManager {
    private Map<PetOwner, Set<Pet>> petOwners;

    public PetManager() {
        petOwners = new HashMap<>();
    }

    public void addOwner(String username) {
        PetOwner newOwner = new PetOwner(username);
        if (petOwners.containsKey(newOwner)) {
            System.out.println("Username " + username + " already exists.");
        } else {
            Set<Pet> initPets = new HashSet<>();
            petOwners.put(newOwner, initPets);
            System.out.println("Added new pet owner: " + username);
        }

//        if (!petOwners.containsKey(username)) {
//            petOwners.put(username, new PetOwner(username));
//            System.out.println("Added new pet owner: " + username);
//        } else {
//            for (PetOwner owner : petOwners.values()) {
//                if (owner.getUsername().equalsIgnoreCase(username)) {
//                    System.out.println("Username " + username + " already exists.");
//                }
//            }
//            System.err.println("addOwner - can not found user and method do not add this user");
//        }
    }

    public PetOwner getOwner(String username) {
        for (PetOwner owner : petOwners.keySet()) {
            if (owner.getUsername().equalsIgnoreCase(username)) {
                return owner;
            }
        }
        return null;
    }

    public void adoptPetForOwner(PetOwner owner, Pet pet) {
        if (petOwners.containsKey(owner)) {
            Set<Pet> pets = petOwners.get(owner);
            if (pets.contains(pet)) {
                System.out.println(owner.getUsername() + " already has a " + pet.getClass().getSimpleName() + " named " + pet.getName() + ".");
                pet.greetOwner(true);
            } else {
                pets.add(pet);
                owner.adopt(pet);
            }
        } else {
            System.out.println("No owner found with the username: " + owner.getUsername());
        }
    }

    public void choosePetForOwner(String username, String petName) {
        PetOwner owner = getOwner(username);
        if (owner != null) {
            owner.choose(petName);
        } else {
            System.out.println("No owner found with the username: " + username);
        }
    }


    public void choosePetOwner(String username) {
        PetOwner owner = getOwner(username);
        if (owner != null) {
            System.out.println("Selected pet owner: " + username);
        } else {
            System.out.println("No owner found with the username: " + username);
        }
    }

    public StringBuilder printAllOwners() {
        StringBuilder result = new StringBuilder("\n");
        for (Map.Entry<PetOwner, Set<Pet>> entry : petOwners.entrySet()) {
            PetOwner owner = entry.getKey();
            result.append("Username: ").append(owner.getUsername()).append(" --> Pets:");
            Set<Pet> pets = entry.getValue();
            if (pets.isEmpty()) {
                result.append(" []");
            } else {
                for (Pet pet : pets) {
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
        if (!(o instanceof PetManager that)) return false;
        boolean areEqual = Objects.equals(petOwners, that.petOwners);
        System.out.println("First PetManager which containing " + this.getOwnerCount() + " owners: hashCode " + this.hashCode() + " and second object PetManager which containing " + ((PetManager) o).getOwnerCount() + " owners: hashCode " + ((PetManager) o).hashCode() + " have equality result: " + areEqual);
        return areEqual;
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

    public Map<PetOwner, Set<Pet>> getPetOwners() {
        return petOwners;
    }

    public void setPetOwners(Map<PetOwner, Set<Pet>> petOwners) {
        this.petOwners = petOwners;
    }
}
