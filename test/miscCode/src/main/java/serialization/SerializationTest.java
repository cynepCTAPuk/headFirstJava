package serialization;

import java.io.*;

public class SerializationTest {
    public static void main(String[] args) throws Exception {
        File file = new File("c:/000/cat.dat");
        Cat cat = new Cat("Barsik",1,2);

        //save cat to file
        FileOutputStream fileOutput = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(cat);
        fileOutput.close();
        outputStream.close();

        //load cat from file
        FileInputStream fiStream = new FileInputStream(file);
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        Object object = objectStream.readObject();
        fiStream.close();
        objectStream.close();

        Cat newCat = (Cat) object;
    }
}
