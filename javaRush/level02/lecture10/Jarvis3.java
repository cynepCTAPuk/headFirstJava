package level02.lecture10;

public class Jarvis3 {

  public void sayHi(String...names) {

    for (String name: names) {
      System.out.println("Добрый вечер, " + name + ", как ваши дела?");
    }
  }

  public static void main(String[] args) {
    Jarvis3 jarvis = new Jarvis3();
    jarvis.sayHi("Тони Старк", "Капитан Америка", "Черная Вдова", "Халк");
  }
}