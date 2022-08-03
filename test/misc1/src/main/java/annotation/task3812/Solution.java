package annotation.task3812;

/* 
Обработка аннотаций
*/

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        PrepareMyTest test = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
        if (test != null) {
            for (String s : test.fullyQualifiedNames()) System.out.println(s);
            return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        PrepareMyTest test = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
        if (test != null) {
            for (Class<?> cl : test.value()) System.out.println(cl.getSimpleName());
            return true;
        }
        return false;
    }
}
