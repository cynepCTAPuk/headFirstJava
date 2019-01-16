package chap12;

public class Exercise2 {
    void print() {
        System.out.println("Exercise2");
    }

    public static void main(String[] args) {
        Exercise2 exercise2 = new Exercise2();
        exercise2 = null;
        try {
            exercise2.print();
        } catch (NullPointerException npi) {
            System.err.println("Watch for Object");
            npi.printStackTrace(System.out);
        }

    }
}
