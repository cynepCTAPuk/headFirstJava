package book.chap17;

public class TestObject {
    public static void main(String[] args) {
        Obj obj1 = new Obj("Obj1");
        Obj obj2 = new Obj("Obj1");
        Obj obj3 = new Obj("Obj3", "Red");
        Obj obj4 = new Obj("Obj4", "Blue", 12);
        obj1.printProperties();
        obj2.printProperties();
        obj3.printProperties();
        obj4.printProperties();
        System.out.println(obj1.hashCode() + "\t" + obj2.hashCode() + "\t" + obj1.equals(obj2));

    }
}

class Obj extends Object {
    private String name;

    private String color;
    private int age;

    void printProperties() {
        System.out.println(toString() + "\t name - \t" + name + " \tcolor - \t" + color + " \t age - " + age);
    }

    Obj(String name) {
        this.name = name;
    }

    Obj(String name, String color) {
        this.name = name;
        this.color = color;
    }

    Obj(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

