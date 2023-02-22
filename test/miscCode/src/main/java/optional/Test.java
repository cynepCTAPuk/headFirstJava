package optional;

import java.util.Optional;
import java.util.function.Function;

public class Test {
	public static void main(String[] args) throws Exception {
		boolean isFooEqualsBar = Optional.of("foo").filter("bar"::equals).isPresent();
		System.out.println(isFooEqualsBar);

		String trimmed = Optional.of(" foo  ").map(String::trim).get();
		System.out.println(trimmed);

		Object num = Optional.of("1234").flatMap((Function<String, Optional<?>>) x -> Optional.of(Integer.parseInt(x))).orElse(-1);
		System.out.println(num);

		Double random = Optional.<Double>empty().orElseGet(Math::random);
		System.out.println(random);

		random = Optional.<Double>empty().orElseThrow(Exception::new);
		System.out.println(random);
	}
}
