package person;

public class Person implements Comparable<Person> {
    String name;
    int age;
    boolean sex;

    public void print() {
        System.out.print("This is " + this.name + ", " +
                (this.sex ? "he" : "she") + " is " + this.age + " years old");
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        if (o.sex == this.sex) {
            return this.name.compareTo(o.name);
        } else {
            if (o.sex && !this.sex) {
                return -1;
            } else if (this.sex == true) {
                return 1;
            }
            return 0;
        }

    }
}
