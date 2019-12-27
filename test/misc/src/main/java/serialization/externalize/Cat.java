package serialization.externalize;

import java.io.*;

class Cat implements Externalizable {
    public String name;
    public int age;
    public int weight;

    public Cat() {
    }

    public Cat(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
//        out.writeInt(age);
        out.writeInt(weight);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
//        age = in.readInt();
        weight = in.readInt();
    }

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + ", age=" + age + ", weight=" + weight + '}';
    }
}

