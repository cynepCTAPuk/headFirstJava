package chap05;

public class Exercese8 {
    public static void main(String[] args) {
        Obj8 obj8 = new Obj8();
        obj8.first();
    }
}


class Obj8 {
    void first() {
        second();
        this.second();
    }

    void second() {

    }
}
