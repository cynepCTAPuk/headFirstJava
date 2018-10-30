package book.chap04;

public class DogTestDrive {
    public static void main(String[] args) {
        Dog one = new Dog();
        one.size=70;
        one.name="Josh";
        Dog two = new Dog();
        two.size=8;
        two.name="Weber";
        Dog three = new Dog();
        three.size=35;
        three.name = "Eliot";

        one.bark(1);
        two.bark(1);
        three.bark(1);

        System.out.println(one.getName()+"\t"+one.getSize());
        one.addSize(10);
        System.out.println(one.size);
        System.out.println(one.toString());
    }
}
 class Dog {
    int size;
    String name;

    void bark(int numOfBarks) {

        for (int j = 0; j < numOfBarks; j++) {
            if (size > 60) System.out.println("\"" + name + "\" barks: \t" + "Woof! Woof!");
            else if (size > 14) System.out.println("\"" + name + "\" barks: \t" + "Ruff! Ruff");
            else System.out.println("\"" + name + "\" barks: \t" + "Yip! Yip!");
        }
/*
        while (numOfBarks > 0) {
            if (size > 60) System.out.println("\"" + name + "\" barks: \t" + "Woof! Woof!");
            else if (size > 14) System.out.println("\"" + name + "\" barks: \t" + "Ruff! Ruff");
            else System.out.println("\"" + name + "\" barks: \t" + "Yip! Yip!");
            numOfBarks = numOfBarks - 1;
        }
*/
    }

     void addSize(int i) {
        size += i;
    }

     void setSize(int size) {
        this.size = size;
    }

     void setName(String name) {
        this.name = name;
    }

     int getSize() {
        return size;
    }

     String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "headFirstJava.book.chap04.Dog{" +
                "size=" + size +
                ", name='" + name + '\'' +
                '}';
    }

}
