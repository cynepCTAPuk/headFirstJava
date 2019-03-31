package beginning.testing.good;

public class Blackbird extends Bird {
    public Blackbird(String name) {
        super(name);
    }

    @Override
    public void feed() {
        setFlying(true);
    }
}
