package annotation.jr.level8lecture09;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@interface Person {
    String name() default "";

    int live();

    int strength();

    int magic() default 0;

    int attack() default 0;

    int defense();
}
