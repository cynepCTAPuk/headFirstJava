package serialization;

import java.io.*;

/*
Переопределение сериализации в потоке
*/
public class SerializeFileOutPutStream implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public SerializeFileOutPutStream(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\r\n".getBytes());
        stream.flush();
//        stream.close();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.defaultWriteObject();
        out.writeObject(fileName);
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        in.defaultReadObject();
        stream = new FileOutputStream((String) in.readObject(), true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.flush();
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        SerializeFileOutPutStream original = new SerializeFileOutPutStream("c:/000/task2022.txt");
        original.writeObject("store data");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(original);
        oos.close();
        baos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        SerializeFileOutPutStream restore = (SerializeFileOutPutStream) ois.readObject();
        ois.close();
        bais.close();

        restore.writeObject("write more data");
    }
}
