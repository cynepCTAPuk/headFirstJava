void dependencyInjection(List<Object> objects) throws Exception {
    //enter your code
}


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {

}

class CandidateNotFindException extends RuntimeException {

}