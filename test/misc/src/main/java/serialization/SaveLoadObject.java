package serialization;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class SaveLoadObject {
    public static void main(String[] args) throws Exception {
        Cat cat = new Cat("Barsik", 1, 3);
        cat.save(new PrintWriter("c:/000/cat.txt"));
        Cat cat1 = new Cat();
        cat1.load(new BufferedReader(new FileReader("c:/000/cat.txt")));
        System.out.println(cat1);

        Dog dog = new Dog("Barbos", 2);
        dog.save(new PrintWriter("c:/000/dog.txt"));
        Dog dog1 = new Dog();
        dog1.load(new BufferedReader(new FileReader("c:/000/dog.txt")));
        System.out.println(dog1);

        Human human = new Human();
        human.cat = cat;
        human.dog = dog;
        human.save(new PrintWriter("c:/000/human.txt"));
        Human human1 = new Human();
        human1.load(new BufferedReader(new FileReader("c:/000/human.txt")));
        System.out.println(human1);
    }
}

class Cat {
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

    public void save(PrintWriter writer) throws Exception {
        writer.println(name);
        writer.println(age);
        writer.println(weight);
        writer.flush();
    }

    public void load(BufferedReader reader) throws Exception {
        name = reader.readLine();
        age = Integer.parseInt(reader.readLine());
        weight = Integer.parseInt(reader.readLine());
    }

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + ", age=" + age + ", weight=" + weight + '}';
    }
}

class Dog {
    public String name;
    public int age;

    public Dog() {
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void save(PrintWriter writer) throws Exception {
        writer.println(name);
        writer.println(age);
        writer.flush();
    }

    public void load(BufferedReader reader) throws Exception {
        name = reader.readLine();
        age = Integer.parseInt(reader.readLine());
    }

    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}

class Human {
    public Cat cat;
    public Dog dog;

    public void save(PrintWriter writer) throws Exception {
        String isCatPresent = cat != null ? "yes" : "no";
        writer.println(isCatPresent);
        writer.flush();

        if (cat != null) cat.save(writer);

        String isDogPresent = dog != null ? "yes" : "no";
        writer.println(isDogPresent);
        writer.flush();

        if (dog != null) dog.save(writer);
    }

    public void load(BufferedReader reader) throws Exception {

        String isCatPresent = reader.readLine();
        if (isCatPresent.equals("yes")) {
            cat = new Cat();
            cat.load(reader);
        }

        String isDogPresent = reader.readLine();
        if (isDogPresent.equals("yes")) {
            dog = new Dog();
            dog.load(reader);
        }
    }

    @Override
    public String toString() {
        return "Human{" + "cat=" + cat + ", dog=" + dog + '}';
    }
}