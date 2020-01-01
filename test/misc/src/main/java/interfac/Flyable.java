package interfac;

interface Flyable {
    String name = "Flier";
    int age = 10;
    void fly();
}

class Mockingly implements Flyable {
    public static void main(String[] args) {
        Mockingly mockingly = new Mockingly();
        mockingly.fly();
        System.out.println(name);
        System.out.println(age);
    }
    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
