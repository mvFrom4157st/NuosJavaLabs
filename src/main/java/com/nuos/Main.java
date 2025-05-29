package com.nuos;

import animals.Animal;
import animals.Cat;
import animals.Dog;
import animals.Hamster;
import veterinar.Veterinarian;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
            new Dog("Barsik"),
            new Cat("Sema"),
            new Hamster("Lidiya")
        };

        Veterinarian vet = new Veterinarian();

        // Прийом у ветеринара
        for (Animal animal : animals) {
            vet.treatAnimal(animal);
        }

        // Поведінка тварин
        for (Animal animal : animals) {
            System.out.println(animal.getName() + " saying: " + animal.makeNoise());
            System.out.print(animal.getName() + " eat: ");
            String[] food = animal.eat();
            for (int i = 0; i < food.length; i++) {
                System.out.print(food[i]);
                if (i < food.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("\n");
        }
    }
}