package level02.lecture02;

public class Main {
  public static void main(String[] args) {
    String s;
    s = null;
    Person person;
    person = new Person();
    person = null;
    Cat cat = new Cat();
    cat.owner = new Person();
    cat.owner.name = "God";
  }
}
