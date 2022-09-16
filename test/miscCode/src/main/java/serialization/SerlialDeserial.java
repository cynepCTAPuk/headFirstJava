package serialization;

import java.io.*;

public class SerlialDeserial {
    private static final String PATH = "c:/000/object.txt";

    public static void main(String[] args) {
        serialize();
        deserialize();
    }

    private static void serialize() {
        SerializableClass serializableClass = new SerializableClass(SerializableClass.class.getName(), 0);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH))) {
            objectOutputStream.writeObject(serializableClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void deserialize() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PATH))) {
            SerializableClass serializableClass = (SerializableClass) objectInputStream.readObject();
            System.out.printf("Title: %s\nSize: %d", serializableClass.title,serializableClass.size);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static class SerializableClass implements Serializable {
        private String title;
        private int size;

        public SerializableClass(String title, int size) {
            this.title = title;
            this.size = size;
        }
    }
}
