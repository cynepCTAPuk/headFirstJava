package chap18_io;
import java.io.*;
class A implements Serializable {
    int a = 10 + (int)(Math.random() * ((20 - 10) + 1));
    public String toString() { return "A{" + "a=" + a + '}'; }
}
class B implements Serializable {
    int b = 10 + (int)(Math.random() * ((20 - 10) + 1));
    A a;
    B() {a = new A();}
    public String toString() {return "B{" + "b=" + b + ", a=" + a + '}';}
}

public class Exercise27 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        B b = new B();
        System.out.println(b);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:/000/objectB.out"));
        out.writeObject("Object B storage 1\n");
        out.writeObject(b);
        out.close(); // Also flushes output

        ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("c:/000/objectB.out"));
        String str = (String) in1.readObject();
        B b2 = (B) in1.readObject();
        System.out.println(str + b2);

    }
}
