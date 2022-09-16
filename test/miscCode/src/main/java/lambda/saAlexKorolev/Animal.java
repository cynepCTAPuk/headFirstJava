package lambda.saAlexKorolev;

public class Animal {
    private String species;
    private boolean canHop;
    private boolean canSwim;

    public Animal(String specieName, boolean hopper, boolean swimmer) {
        species = specieName;
        canHop = hopper;
        canSwim = swimmer;
    }

    public boolean canHop() {
        return canHop;
    }

    public boolean canSwim() {
        return canSwim;
    }

    public boolean hasName() {
        return species != null;
    }

    public String toString() {
        return species;
    }
}
