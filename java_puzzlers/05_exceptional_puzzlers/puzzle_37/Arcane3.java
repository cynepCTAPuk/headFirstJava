package puzzle_37;

public class Arcane3 implements Type3 {
    public void f() {
        System.out.println("Hello world!");
    }

    public static void main(String[] args) {
        Type3 t3 = new Arcane3();
        t3.f();
    }
}
