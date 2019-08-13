package chap12_Enums_Annotations;
// Demonstrate a repeated annotation

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Make MyAnno repeatable
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnos.class)
@interface MyAnno2 {
    String str() default "Testing";

    int val() default 9000;
}

// This is the container annotation
@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnnos {
    MyAnno2[] value();
}

public class RepeatAnno {
    // Repeat MyAnno2 on myMethod
    @MyAnno2(str = "First annotation", val = -1)
    @MyAnno2(str = "Second annotation", val = 99)
    public static void myMethod(String str, int i) {
        RepeatAnno ob = new RepeatAnno();
        try {
            Class<?> c = ob.getClass();
            // Obtain the annotations for myMethod()
            Method m = c.getMethod("myMethod", String.class, int.class);
            //Display the repeated MyAnno annotations
            Annotation anno = m.getAnnotation(MyRepeatedAnnos.class);
            System.out.println(anno);

            System.out.println();
            Annotation[] annos = m.getAnnotationsByType(MyAnno2.class);
            for(Annotation a: annos) System.out.println(a);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        myMethod("test", 10);
    }
}
