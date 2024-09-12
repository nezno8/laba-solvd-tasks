package com.solvd.laba.tamagotchi;

public class Main {
    public static void main(String[] args) {

        System.out.println("___Equals__________________________________________________________________");
        System.out.println("---PET---------------------------------------------------------------------");
        Pet pet = new Cat("Sunny", "Siamese", "brown");
        Pet pet2 = new Dog("Buddy", "Labrador", "black");
        Pet pet3 = new Dog("Buddy", "Labrador", "black");

        System.out.println("Equals Pet 1 to Pet 2");
        boolean petEquals1to2 = pet.equals(pet2);
        System.out.println("Equals Pet 1 to Pet 3");
        boolean petEquals1to3 = pet.equals(pet3);
        System.out.println("Equals Pet 2 to Pet 3");
        boolean petEquals2to3 = pet2.equals(pet3);

        System.out.println("---------------------------------------------------------------------------");

        System.out.println("---PET-OWNER---------------------------------------------------------------");
        PetOwner petOwner = new PetOwner("Jill");
        PetOwner petOwner2 = new PetOwner("John");
        PetOwner petOwner3 = new PetOwner("Amanda");

        System.out.println("Equals Owner 1 to Owner 2");
        boolean ownerEquals1to2 = petOwner.equals(petOwner2);
        System.out.println("Equals Owner 1 to Owner 3");
        boolean ownerEquals1to3 = petOwner.equals(petOwner3);
        System.out.println("Equals Owner 2 to Owner 3");
        boolean ownerEquals2to3 = petOwner2.equals(petOwner3);

        System.out.println("---------------------------------------------------------------------------");

        System.out.println("---PET-MANAGER-1-----------------------------------------------------------");
        PetManager manager = new PetManager();
        manager.addOwner("John");
        manager.addOwner("Jill");
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("---PET-MANAGER-2------------------------------------------------------------");
        PetManager manager2 = new PetManager();
        manager2.addOwner("Jill");
        manager2.addOwner("John");
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("---PET-MANAGER-3------------------------------------------------------------");
        PetManager manager3 = new PetManager();
        manager3.addOwner("John");
        manager3.addOwner("Jill");
        manager3.addOwner("Amanda");
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Equals pet manager 1 to pet manager 2");
        boolean managerEquals1to2 = manager.equals(manager2);
        System.out.println("Equals pet manager 1 to pet manager 3");
        boolean managerEquals1to3 = manager.equals(manager3);
        System.out.println("Equals pet manager 2 to pet manager 3");
        boolean managerEquals2to3 = manager2.equals(manager3);
        System.out.println("---------------------------------------------------------------------------");


        System.out.println("--PRINT----------------------------------------------------------------------");

        System.out.println("Pet : " + pet);
        System.out.println("---------------------------------------------------------------------------");

        System.out.println(new Cat("Sunny", "Siamese", "Brown").toStringDetailed());

        System.out.println("");

        System.out.println("Pet owner : " + petOwner);
        System.out.println("---------------------------------------------------------------------------");

        manager.addOwner("Cecilia");
        PetOwner cecilia = manager.getOwner("Cecilia");
        cecilia.adopt(new Cat("Sunny", "Siamese", "brown"));
        System.out.println("\n");
        cecilia.adopt(new Dog("Buddy", "Labrador", "black"));
        System.out.println("\n");
        manager.addOwner("Cecilia");

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Pet manager : " + manager);
        System.out.println("---------------------------------------------------------------------------");


        System.out.println("---------------------------------------------------------------------------");

        IPlayWithPet<Cat> playWithMyPet = (myPet) -> {
            System.out.println(myPet.getName() + " is playing happily!");
            myPet.setActive(true);
        };

        Cat myCat = new Cat("Whiskers", "Siamese", "cream");
        playWithMyPet.play(myCat);

        ITeachTrick<Cat> teachTrickToMyPet = (myPet, trick) -> {
            System.out.println(myPet.getName() + " has learned to " + trick + "!");
            System.out.println(myPet.getName() + " performs the trick perfectly!");
        };

        teachTrickToMyPet.teachTrick(myCat, "roll over");

        IFeedPet<Cat> feedMyPet = (myPet, food) -> {
            myPet.eat(food);
            System.out.println(myPet.getName() + " has been fed " + food + "!");
            System.out.println("Hunger level: " + myPet.getHungerLevel());
        };

        feedMyPet.feed(myCat, Food.FISH);

        System.out.println("---------------------------------------------------------------------------");


    }
}

