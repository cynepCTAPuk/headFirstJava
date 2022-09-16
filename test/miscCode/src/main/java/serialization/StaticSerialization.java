package serialization;

import java.io.*;

/*
Как сериализовать static?
*/
public class StaticSerialization {
    public static class ClassWithStatic implements Serializable {
        private static final long serialVersionUID = 123456789L;
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        private void writeObject(ObjectOutputStream oos) throws IOException {
            oos.defaultWriteObject();
            oos.writeObject(staticString);
        }

        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            ois.defaultReadObject();
            staticString = (String) ois.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClassWithStatic classWithStatic = new ClassWithStatic();
        classWithStatic.i = 1;
        classWithStatic.j = 2;
        System.out.println(classWithStatic.i + ":" + classWithStatic.j + ":" + ClassWithStatic.staticString);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(classWithStatic);

        classWithStatic.i = 3;
        classWithStatic.j = 4;
        ClassWithStatic.staticString = "Just string";
        System.out.println(classWithStatic.i + ":" + classWithStatic.j + ":" + ClassWithStatic.staticString);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
        ClassWithStatic another = new ClassWithStatic();
        another = (ClassWithStatic) ois.readObject();
        System.out.println(another.i + ":" + another.j + ":" + ClassWithStatic.staticString);

        oos.close();
        ois.close();
    }
}
