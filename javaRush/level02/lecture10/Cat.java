package level02.lecture10;

public class Cat {

  String name;

  public Cat(int age) {
    this.age = age;
  }
  public Cat() {
    this.age = 0;
  }

  int age;

  public void sayMeow() {
    System.out.println("Мяу!");
  }

  public void jump() {
    System.out.println("Прыг-скок!");
  }

  public static void main(String[] args) {
    Cat barsik = new Cat();
    barsik.age = 3;
    barsik.name = "Барсик";

    barsik.sayMeow();
    barsik.jump();

  }
}