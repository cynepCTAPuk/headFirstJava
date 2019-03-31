package beginning.testing.good;

public abstract class Bird {
    private final String name;
    private boolean isFlying;

    public Bird(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void setFlying(boolean flying) {
        isFlying = flying;
    }

    @Override
    public String toString() {
        return "Bird{" + "name='" + name + '\'' + ", isFlying=" + isFlying + '}';
    }

    public boolean isFlying() {
        return isFlying;
    }

    public abstract void feed();
}
