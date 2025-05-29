package animals;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public String makeNoise() {
        return "Gav-gav";
    }

    @Override
    public String[] eat() {
        return new String[]{"meat", "bones", "dry food"};
    }

    @Override
    public String getDescription() {
        return "Dog is a loyal and protective domestic animal. Sometimes has a povodok";
    }
}
