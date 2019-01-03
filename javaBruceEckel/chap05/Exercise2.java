package chap05;

public class Exercise2 {
    public static void main(String[] args) {
        Obje obje1 = new Obje();
        Obje obje2 = new Obje("New");
        System.out.println(obje1.str);
        System.out.println(obje2.str);
    }
}

class Obje {
    String str = "Old";

    Obje() {
    }

    Obje(String str) {
        this.str = str;
    }
}

