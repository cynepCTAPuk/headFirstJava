package string;

public class Multiline {
	public static void main(String[] args) {
		System.out.println(jdk13());
		System.out.println();
		System.out.println(jdk14());
	}

	private static String jdk13() {
		return "Select f.id, f.name, f.text \n" +
				"from file f \n" +
				"where f.creation_date > :week_before";
	}

	private static String jdk14() {
		return """
				Select f.id, f.name, f.text \
				from file f \
				where f.creation_date > :week_before
				""";
	}
}
