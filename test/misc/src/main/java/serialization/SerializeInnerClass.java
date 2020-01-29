package serialization;

import java.io.*;

public class SerializeInnerClass implements Serializable{
    public class A implements Serializable {
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public class C extends B {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializeInnerClass original = new SerializeInnerClass();
        A a = original.new A("interfaces");
        B b = original.new B("b");
        C c = original.new C("c");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(c);
        oos.close();
        baos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        C restore = (C) ois.readObject();
        ois.close();
        bais.close();

        System.out.println(restore);
    }
}
