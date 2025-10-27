package Animals;

public class Parrot extends Animal {
    {legs = 2;
        name = "Papuga";}

    @Override
    public String getDescription() {
        return name + " ma " + legs + " nóg";
    }
}
