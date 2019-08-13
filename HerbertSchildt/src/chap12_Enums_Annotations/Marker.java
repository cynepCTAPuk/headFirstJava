package chap12_Enums_Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// An annotation type declaration that include defaults
@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker {}

class Marker {
    @MyMarker
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
