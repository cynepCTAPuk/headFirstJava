//: chap20_annotations/database/Uniqueness.java
// Sample of nested chap20_annotations
package chap20_annotations.database;
public @interface Uniqueness {
    Constraints constraints()
            default @Constraints(unique=true);
} ///:~