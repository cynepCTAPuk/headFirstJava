package chap05;

public class Exercese9 {
    public static void main(String[] args) {
        Tomato tomato = new Tomato(10);
    }
}

class Tomato {
    Tomato() {
        System.out.println("new Tomato");
    }

    Tomato(int i) {
        this();
        System.out.println("Weight: " + i);
    }
}
