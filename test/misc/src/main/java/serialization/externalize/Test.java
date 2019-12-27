package serialization.externalize;

import serialization.SerializeObject;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cat cat = new Cat("Barsik", 1, 2);
        System.out.println(cat);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(cat);

        cat = new Cat("Murik", 3, 4);
        System.out.println(cat);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
        Cat newCat = new Cat();
        newCat = (Cat) ois.readObject();
        System.out.println(newCat);
    }
}
