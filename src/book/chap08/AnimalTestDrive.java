package book.chap08;

public class AnimalTestDrive {
    public static void main(String[] args) {
        MyAnimalList list = new MyAnimalList();
        System.out.println(list);
        Dog a = new Dog();
        Cat c = new Cat();
        Tiger t = new Tiger();
        list.add(a);
        System.out.println(a);
        System.out.println(a.hashCode());
        list.add(c);
        System.out.println(c);
        System.out.println(c.hashCode());
        list.add(t);
        System.out.println(t);
        System.out.println(t.hashCode());
    }
}
