package beginning.testing.bad;

public class Blackbird {
    private final String name;
    private boolean isFlying;

    public Blackbird() {
        this.name = "Blackbird";
        this.isFlying = true;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", isFlying=" + isFlying +
                '}';
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void feed() {
        isFlying = true;
    }
}
