package veterinar;

import animals.Animal;

public class Veterinarian {

    public void treatAnimal(Animal animal) {
        System.out.println("Veterinary prinimaet animal:");
        System.out.println("    Name: " + animal.getName());
        System.out.println("    Desc: " + animal.getDescription() + "\n");
    }
}
