package beginning.testing.bad;

public class Bird {
    private final String name;
    private boolean isFlying;

    public Bird(String name) {
        this.name = name;
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
        if (name.equals("Blackbird")) {
            isFlying = true;
        } else {
            isFlying = false;
        }
    }
}
