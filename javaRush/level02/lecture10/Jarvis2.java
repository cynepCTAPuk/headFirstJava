package level02.lecture10;

public class Jarvis2 {

  public void sayHi(String firstGuest) {
    System.out.println("Добрый вечер, " + firstGuest + ", как ваши дела?");
  }

  public void sayHi(String firstGuest, String secondGuest) {
    System.out.println("Добрый вечер, " + firstGuest + ", " + secondGuest + ", как ваши дела?");
  }

  public static void main(String[] args) {
    Jarvis2 jarvis = new Jarvis2();
    jarvis.sayHi("Тони Старк");
    jarvis.sayHi("Тони Старк", "Капитан Америка");
  }
}