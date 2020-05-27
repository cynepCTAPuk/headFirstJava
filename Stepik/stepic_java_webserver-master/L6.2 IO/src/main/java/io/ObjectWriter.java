package io;

import java.io.*;

/**
 * @author v.chibrikov
 */
public class ObjectWriter {
    public static void main(String[] args) {
        stringExample();
        descriptorExample();
    }

    private static void stringExample() {
        write("Ph'nglui mglw'nafh Cthulhu R'lyeh wgah'nagl fhtagn", "./string.bin");
        String fromFile = (String) read("./string.bin");
        System.out.println(fromFile);
    }

    private static void descriptorExample() {
        Descriptor descriptor = new Descriptor("Anna", 15);
        write(descriptor, "./descriptor.bin");
        Descriptor fromFile = (Descriptor) read("./descriptor.bin");
        System.out.println(fromFile);
    }

    public static void write(Object object, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(object);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object read(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
