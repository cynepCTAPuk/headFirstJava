package optional;

import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        String hello = "Hello";
        Optional<String> optional = Optional.of(hello);
        System.out.println(optional.isPresent());
        optional.ifPresent(s -> System.out.println(s.length()));
        System.out.println(optional.get());
        System.out.println(optional.orElse("oops..."));
    }
}
