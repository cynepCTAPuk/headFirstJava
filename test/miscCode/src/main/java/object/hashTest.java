package object;

public class hashTest {
	public static void main(String[] args) {
		String a = new String("бг");
		String b = new String("бг");
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(a == b);

		int i = 1001;
		Integer aa = i;
		Integer bb = i;
		System.out.println(aa.hashCode());
		System.out.println(bb.hashCode());
		System.out.println(aa == bb);

	}
}
