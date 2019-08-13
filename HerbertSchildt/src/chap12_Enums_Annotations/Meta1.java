package chap12_Enums_Annotations;

import java.lang.reflect.Method;

class Meta1 {
    // myMethod now has two arguments
    @MyAnno(str = "Two Parameters", val = 19)
    public static void myMethod(String str, int i) {
        Meta1 meta = new Meta1();
        // Obtain the annotation for this method and display the values of the members
        try {
            Class<?> obClass = meta.getClass();
            // Here, the parameter types are specified
            Method method = obClass.getMethod("myMethod", String.class, int.class);
            MyAnno annotation = method.getAnnotation(MyAnno.class);
            System.out.println(annotation.str() + " " + annotation.val());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        myMethod("test", 10);
    }
}
