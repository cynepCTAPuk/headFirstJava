// https://habr.com/ru/companies/jugru/articles/652821/
package test;

import java.io.*;
import java.util.Base64;

public class recordsTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Point point = new Point(1, 1);
		serialization(point);
		deSerialization("rO0ABXNyABZ0ZXN0LnJlY29yZHNUZXN0JFBvaW50AAAAAAAAAAACAAJJAAF4SQABeXhwAAAAAQAAAAE=");
	}

	public record Point(int x, int y) implements Serializable {
		public Point {
			if (x < 0 || y < 0) throw new IllegalArgumentException();
		}
	}

	private static void serialization(Point point) throws IOException {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		try (ObjectOutputStream oos = new ObjectOutputStream(result)) {
			oos.writeObject(point);
		}
		System.out.println(Base64.getEncoder().encodeToString(result.toByteArray()));
	}

	private static void deSerialization(String s) throws IOException, ClassNotFoundException {
		byte[] input = Base64.getDecoder().decode(s);
		try (ObjectInputStream ols = new ObjectInputStream(new ByteArrayInputStream(input))) {
			Point point = (Point) ols.readObject();
			System.out.println(point);
		}
	}
}
