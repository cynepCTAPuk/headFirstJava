package chap12_Enums_Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// A marker annotation
@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker {
}

class Marker {
    // Annotate a method using a marker. Notice that no () is needed
    @MyMarker
    public static void myMethod() {
        Marker marker = new Marker();
        try {
            Method method = marker.getClass().getMethod("myMethod");
            // Determine if the annotation is present
            if (method.isAnnotationPresent(MyMarker.class))
                System.out.println("MyMarker is present");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        myMethod();
    }
}
