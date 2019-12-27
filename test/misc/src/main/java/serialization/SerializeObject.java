package serialization;

import java.io.*;

/*
Как сериализовать что-то свое?
*/
public class SerializeObject {
    public static class Object implements Serializable {
        public String string1;
        public String string2;
    }

    public static int stringCount = 0;

    public static class String implements Serializable {
        private final int number;

        public String() {
            number = ++stringCount;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }

    public static void main(java.lang.String[] args) throws IOException, ClassNotFoundException {
        SerializeObject.Object obj = new SerializeObject.Object();
        SerializeObject.String str1 = new SerializeObject.String();
        SerializeObject.String str2 = new SerializeObject.String();
        obj.string1 = str1;
        obj.string2 = str2;
        System.out.println(obj.string1.number + ":" + obj.string2.number);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(obj);

        obj.string1 = str2;
        obj.string2 = str1;
        System.out.println(obj.string1.number + ":" + obj.string2.number);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
        SerializeObject.Object newObj = new SerializeObject.Object();
        newObj = (Object) ois.readObject();
        System.out.println(newObj.string1.number + ":" + newObj.string2.number);
    }
}
