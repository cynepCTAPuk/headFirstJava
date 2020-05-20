Base createProxy(Base object) throws Exception {
    //enter your code
    return null;
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging {
}

interface Base {
    void method1();

    void method2();
}