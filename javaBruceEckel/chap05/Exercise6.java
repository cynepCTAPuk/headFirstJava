package chap05;

public class Exercise6 {
    public static void main(String[] args) {
        Obj6 obj61 = new Obj6(11, "11");
        Obj6 obj62 = new Obj6("12", 12);
    }
}

class Obj6 {
    Obj6(int i, String s) {
        System.out.println("int: " + i + " String: " + s);
    }

    Obj6(String s, int i) {
        System.out.println("String: " + s + " int: " + i);
    }
}
