package chap05_initialization;

public class Exercise3 {
    public static void main(String[] args) {
        Obj3 obj3 = new Obj3();
    }
}

class Obj3 {
    Obj3() {
        System.out.println("new Obj3");
    }
}
