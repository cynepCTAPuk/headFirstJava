package chap12_exceptions;

class Except extends Exception {
    String string;
    public Except(String message) { string = message; }
    public String getString() { return string; }
}
public class Exercise4 {
    public static void main(String[] args)  {
        try {
            Except except = new Except("Long way away");
            System.err.println(except.getString());
            throw except;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
