package web.stepik.web1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class AnnotationTest {
    static Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) throws NoSuchMethodException {
        Class myClass = MyClass.class;
        CreatedBy annotationC = (CreatedBy) myClass.getAnnotation(CreatedBy.class);

        System.out.println("Author of the class: " + annotationC.author());
        logger.info("Author of the class: " +annotationC.author());
        logger.info("Date of writing of the class: " + annotationC.date());


        Method method = myClass.getDeclaredMethod("method");
        CreatedBy annotationM = method.getAnnotation(CreatedBy.class);
        System.out.println(annotationM);
    }
}
@CreatedBy(author = "tully",date = "01.01.2010")
class MyClass {
    @CreatedBy(author = "tully",date = "01.01.2010")
    private void method() {
//        doing something
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@interface CreatedBy {
    String author();

    String date();
}


