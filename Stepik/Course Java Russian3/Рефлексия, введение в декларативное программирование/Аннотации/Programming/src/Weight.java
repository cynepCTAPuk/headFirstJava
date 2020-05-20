void callMethodByWeight(Object object) throws Exception {
    //enter your code
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Weight {
    int value();
}