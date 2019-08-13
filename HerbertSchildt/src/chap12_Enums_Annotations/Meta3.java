package chap12_Enums_Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// An annotation type declaration that include defaults
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno1 {
    String str() default "Testing";

    int val() default 9000;
}

class Meta3 {
    @MyAnno1() // both str and val default
//    @MyAnno1(str = "some string") // val defaults
//    @MyAnno1(val = 100) // str defaults
//    @MyAnno1(str = "Testing", val = 100) // no defaults
    public static void myMethod() {
        Meta3 meta = new Meta3();
        // Obtain the annotation for this method and display the values of the members
        try {
            Class<?> obClass = meta.getClass();
            Method method = obClass.getMethod("myMethod");
            MyAnno1 annotation = method.getAnnotation(MyAnno1.class);
            System.out.println(annotation.str() + " " + annotation.val());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        myMethod();
    }
}
