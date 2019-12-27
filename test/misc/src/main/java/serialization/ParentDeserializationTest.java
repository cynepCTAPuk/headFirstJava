/**
 * https://javarush.ru/groups/posts/1406-serializacija-kak-ona-estjh-chastjh-1
 */
package serialization;

import java.io.*;

public class ParentDeserializationTest {

    public static void main(String[] args) {
        try {
            System.out.println("Creating...");
            Child c = new Child(1);
            System.out.printf("%-25s %d:%d\n", "Fields original Child c:", c.field, c.i);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            c.field = 10;
            System.out.printf("%-25s %d:%d\n", "Fields changed Child c:", c.field, c.i);
            System.out.println("Serializing...");
            oos.writeObject(c);
//            oos.flush();
//            baos.flush();
            oos.close();
            baos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            System.out.println("Deserializing...");
            Child c1 = (Child) ois.readObject();
            System.out.printf("%-25s %d:%d\n", "Fields after Child c1:", c1.field, c1.i);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static class Parent {
        protected int field;

        protected Parent() {
            field = 5;
            System.out.println("Parent::Constructor");
        }

        public int getField() {
            return field;
        }
    }

    public static class Child extends Parent implements Serializable {
        protected int i;

        public Child(int i) {
            this.i = i;
            System.out.println("Child::Constructor");
        }

        public int getI() {
            return i;
        }
    }
}