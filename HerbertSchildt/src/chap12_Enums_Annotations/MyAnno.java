package chap12_Enums_Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// A simple annotation type
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val();
}
