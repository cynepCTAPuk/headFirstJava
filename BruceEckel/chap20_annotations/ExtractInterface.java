//: chap20_annotations/ExtractInterface.java
// APT-based annotation processing.
package chap20_annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {
    public String value();
} ///:~