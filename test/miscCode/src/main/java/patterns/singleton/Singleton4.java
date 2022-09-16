package patterns.singleton;

public class Singleton4 {
    private static class Holder {
        private static Singleton4 INSTANCE = new Singleton4();
    }

    public Singleton4() {
    }

    public static Singleton4 getInstance() {
        return Holder.INSTANCE;
    }

    public void print() {
        System.out.println(this);
    }
}
