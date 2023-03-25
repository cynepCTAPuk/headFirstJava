package oop;

public class OverridePrivateMethodByNestedClass {
	private String i_m_private = "I am private member, not accessible outside this Class";

	private void privateMethod() {
		System.out.println("Private method of Outer Class");
	}

	public static void main(String[] args) {
		OverridePrivateMethodByNestedClass outerClass = new OverridePrivateMethodByNestedClass();
		NestedClass nestedClass = outerClass.new NestedClass();
		//shows that private method are accessible in inner class.
		nestedClass.showPrivate();
		// This will not call private method from inner class, which shows you can not override private method inside inner class.
		outerClass = nestedClass;
		outerClass.privateMethod();
	}

	class NestedClass extends OverridePrivateMethodByNestedClass {
		public void showPrivate() {
			System.out.println("Accessing Private members of Outer class: " + i_m_private);
			privateMethod();
		}

		// private method trying to be overridden, instead it’s just hiding parent class method.
		private void privateMethod() {
			System.out.println("Private method of Nested Class");
		}
	}
}
