Map<String, Operation> createPoolOperation(List<Object> objects) throws Exception {
    //enter your code
    return null;
}


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BotRequestMapping {
    String value();
}

@FunctionalInterface
interface Operation {
    void call() throws Exception;
}