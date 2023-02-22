package string;

public class RegionMatchesTest {
	public static void main(String[] args) {
		String s1 = "Welcome to channel Java";
		String s2 = "Java";
		String s3 = "JAVA";

		System.out.println(s1.regionMatches(19, s2, 0, 4));
		System.out.println(s1.regionMatches(19, s3, 0, 4));
		System.out.println(s1.regionMatches(true, 19, s3, 0, 4));
	}
}
