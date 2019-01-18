package chap12_exceptions;

public class Exercise1 extends Exception{
    public Exercise1() {}
    public Exercise1(String message) { super(message); }
    public Exercise1(String message, Throwable cause) {super(message, cause);}
    public Exercise1(Throwable cause) {super(cause);}

    void ex() throws MyException {
        System.out.println("My Exception");
        throw new MyException("---- Commentary");
    }

    public static void main(String[] args) {
        Exercise1 exercise1 = new Exercise1();
        try {
            System.out.println("try");
            exercise1.ex();
        } catch (MyException e) {
            System.out.println("catch");
            e.printStackTrace(System.out);
        } finally {
            System.out.println("finally");
        }

    }
}
