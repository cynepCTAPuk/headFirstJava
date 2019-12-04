package oop;

public class PhoneTest {
    public static void main(String[] args) {
        Phone myPhone = new MyPhone(2000, "Apple");
        myPhone.call();
        myPhone.ring();
    }
}

class Phone {
    private int year;
    private String company;

    public Phone(int year, String company) {
        this.year = year;
        this.company = company;
    }

    private void openConnection() {
        System.out.println("Соединение устанавливается");
    }

    public void call() {
        openConnection();
        System.out.println("Вызываю номер");
    }

    public void ring() {
        System.out.println("Дзынь-дзынь");
    }
}

class MyPhone extends Phone {
    public MyPhone(int year, String company) {
        super(year, company);
    }
}