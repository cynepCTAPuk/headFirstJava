package serialization.externalize;

import serialization.SerializeObject;

import java.io.*;

public class ExternalizableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cat origin = new Cat("Barsik", 1, 2);
        System.out.println(origin);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(origin);
        oos.close();
        baos.close();

        origin = new Cat("Murik", 3, 4);
        System.out.println(origin);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Cat restore = (Cat) ois.readObject();
        System.out.println(restore);
        ois.close();
        bais.close();
    }
}
