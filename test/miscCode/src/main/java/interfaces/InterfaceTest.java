package interfaces;

interface InterfaceTest {
	int myMethod(String s);
}

class Test {
	public static void main(String[] args) {
		InterfaceTest interfaceTest = s -> Integer.parseInt(s);
		System.out.println(interfaceTest.myMethod("11"));
	}
}
