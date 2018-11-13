package level02.lecture10;

public class Jarvis1 {

  public void sayHi(String name) {
    System.out.println("Добрый вечер, " + name + ", как ваши дела?");
  }

  public static void main(String[] args) {
    Jarvis1 jarvis = new Jarvis1();
    jarvis.sayHi("Тони Старк");
  }
}