package animals;

public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String makeNoise();

    public abstract String[] eat();

    public abstract String getDescription();
}
