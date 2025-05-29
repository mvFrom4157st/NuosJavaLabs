package animals;

public class Hamster extends Animal {

    public Hamster(String name) {
        super(name);
    }

    @Override
    public String makeNoise() {
        return "Yak popalo pishit";
    }

    @Override
    public String[] eat() {
        return new String[]{"grain", "nuts", "fruits"};
    }

    @Override
    public String getDescription() {
        return "Hamster is a small. Easy to flatten";
    }
}
