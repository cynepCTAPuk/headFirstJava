package chap12_Enums_Annotations;
// A single-member annotation

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface MySingle {
    int value(); // this variable name must be value
}

public class Single {
    // Annotate a method using a single-member annotation
    @MySingle(100)
    public static void MyMethod() {
        Single single = new Single();
        try {
            MySingle anno = single.getClass()
                    .getMethod("MyMethod").getAnnotation(MySingle.class);
            System.out.println(anno.value());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyMethod();
    }
}
