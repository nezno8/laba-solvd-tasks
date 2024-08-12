package com.solvd.laba.tamagotchi;

public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog("Azor", "Labrador", "Black");
        Cat cat = new Cat("Sunny", "Siamese", "White");
        Parrot parrot = new Parrot("Koko", "African Red Parrot", "Red");
        Rabbit rabbit = new Rabbit("Bunny", "Holland Lop", "Grey");

        dog.eat(Food.CRISPS);
        cat.eat(Food.FISH);
        parrot.eat(Food.FRUIT);
        rabbit.eat(Food.VEGETABLES);


        System.out.println("Animal hunger levels before time passage:");
        System.out.println("Dog: " + parrot.getHungerLevel());
        System.out.println("Cat: " + parrot.getHungerLevel());
        System.out.println("Parrot: " + parrot.getHungerLevel());
        System.out.println("Rabbit: " + rabbit.getHungerLevel());

        dog.tick();
        cat.tick();
        parrot.tick();
        rabbit.tick();

        System.out.println("\nAnimal hunger levels after time passage:");
        System.out.println("Dog: " + parrot.getHungerLevel());
        System.out.println("Cat: " + parrot.getHungerLevel());
        System.out.println("Parrot: " + parrot.getHungerLevel());
        System.out.println("Rabbit: " + rabbit.getHungerLevel());
    }
}

