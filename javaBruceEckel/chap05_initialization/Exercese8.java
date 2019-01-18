package chap05_initialization;

public class Exercese8 {
    public static void main(String[] args) {
        Obj8 obj8 = new Obj8();
        obj8.first();
    }
}


class Obj8 {
    void first() {
        System.out.println("first");
        second();
        this.second();
    }

    void second() {
        System.out.println("second");
    }
}
