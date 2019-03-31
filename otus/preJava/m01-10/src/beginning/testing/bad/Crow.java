package beginning.testing.bad;

public class Crow {
    private final String name;
    private boolean isFlying;

    public Crow() {
        this.name = "Crow";
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
        isFlying = false;
    }
}
