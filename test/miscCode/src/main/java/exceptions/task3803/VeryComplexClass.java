package exceptions.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object x = new Integer(0);
        System.out.println((String) x);
    }

    public void methodThrowsNullPointerException() {
        String[] strings = new String[1];
        System.out.println(strings[0].getClass());
    }

    public static void main(String[] args) {
//        new VeryComplexClass().methodThrowsClassCastException();
//        new VeryComplexClass().methodThrowsNullPointerException();
    }
}
