package animals;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public String makeNoise() {
        return "Meow-meow";
    }

    @Override
    public String[] eat() {
        return new String[]{"fish", "milk", "meat"};
    }

    @Override
    public String getDescription() {
        return "Cat is affectionate domestic animal.";
    }
}
