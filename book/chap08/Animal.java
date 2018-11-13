package chap08;

abstract public class Animal {
    String picture;
    String food;
    String hunger;
    String boundaries;
    String location;

    public Animal() {
        System.out.println("Making an Animal");
    }

    abstract void makeNoise();

    abstract void eat();

    void sleep() {

    }

    abstract void roam();
}
