package com.codingcorcs.demo.MiniLabs.Jett;

import java.util.ArrayList;

public class Inheritance {

    public static abstract class Animal {

        private String itemName;
        private int Lbs;

        public Animal(String name, int pnds){
            this.itemName = name;
            this.Lbs = pnds;
        }

        public int getLbs() {
            return Lbs;
        }

        @Override
        public String toString() {
            return String.format("%s, Lbs %s", itemName, Lbs);
        }
    }

    public static class Cat extends Animal{

        private String Pattern;

        public Cat(String Pattern){
            super("Cat", 10);
            this.Pattern = Pattern;
        }

        @Override
        public String toString() {
            return String.format("%s, Pattern: %s", super.toString(), Pattern);
        }
    }

    public static abstract class Dog extends Animal{
        private String breed;

        public Dog(String breed, int Lbs){
            super("Dog", Lbs);
            this.breed = breed;
        }

        @Override
        public String toString() {
            return String.format("%s, Breed: %s", super.toString(), breed);
        }
    }

    public static class Terrier extends Dog{
        private String furColor;
        public Terrier(String furColor){
            super("Terrier", 50);
            this.furColor = furColor;
        }

        @Override
        public String toString() {
            return String.format("%s, Fur color: %s", super.toString(), furColor);
        }
    }



    public static void main(String[] args) {
        ArrayList<Animal> lunch = new ArrayList<>();

        lunch.add(new Cat("spots"));
        lunch.add(new Cat("spots"));
        lunch.add(new Terrier("brown"));


        lunch.forEach((Animal -> {
            System.out.println(Animal);
        }));

    }


}