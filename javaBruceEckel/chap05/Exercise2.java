package chap05;

public class Exercise2 {
    public static void main(String[] args) {
        Obj2 obj21 = new Obj2();
        Obj2 obj22 = new Obj2("New");
        System.out.println(obj21.str);
        System.out.println(obj22.str);
    }
}

class Obj2 {
    String str = "Old";

    Obj2() {
    }

    Obj2(String str) {
        this.str = str;
    }
}

