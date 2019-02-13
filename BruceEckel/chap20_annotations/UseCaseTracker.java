//: chap20_annotations/UseCaseTracker.java
package chap20_annotations;
import java.lang.reflect.*;
import java.util.*;

public class UseCaseTracker {
    public static void
    trackUseCases(List<Integer> useCases, Class<?> cl) {
        int k = 0;
        for(Method m : cl.getDeclaredMethods()) {
            System.out.println(++k + "-------" + m);
            UseCase uc = m.getAnnotation(UseCase.class);
            System.out.println("--------" + uc);
            if(uc != null) {
                System.out.println("Found Use Case:" + uc.id() + " " + uc.description());
                useCases.remove(Integer.valueOf(uc.id()));
            }
            System.out.println();

        }
        for(int i : useCases) {
            System.out.println("Warning: Missing use case-" + i);
        }
    }
    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtils.class);
    }
} /* Output:
Found Use Case:47 Passwords must contain at least one numeric
Found Use Case:48 no description
Found Use Case:49 New passwords can’t equal previously used ones
Warning: Missing use case-50
*///:~