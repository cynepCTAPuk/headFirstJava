package chap12_Enums_Annotations;
// Show all annotations for a class and a method

import java.lang.annotation.Annotation;

@What(description = "An annotation test class")
@MyAnno(str = "Meta2", val = 99)
class Meta2 {
    @What(description = "An annotation test method")
    @MyAnno(str = "Testing", val = 100)
    public static void myMethod() {
        Meta2 meta = new Meta2();
        try {
            Annotation[] annotations;

            // Display all annotations for Meta2
            annotations = meta.getClass().getAnnotations();
            System.out.println("\nAll annotations for Meta2:");
            for (Annotation a : annotations) System.out.println(a);

            // Display all annotations for myMethod
            annotations = meta.getClass().getMethod("myMethod").getAnnotations();
            System.out.println("\nAll annotations for myMethod:");
            for (Annotation a : annotations) System.out.println(a);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        myMethod();
    }
}
