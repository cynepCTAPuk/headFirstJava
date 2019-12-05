package oop;

public class PhoneTest {
    public static void main(String[] args) {
        AbstractPhone cellPhone = new CellPhone(2000, 12);
        cellPhone.call("1 234 567890");
        cellPhone.ring("2 345 678901");
        SmartPhone smartPhone = new SmartPhone(2008, 13, "IOS");
        smartPhone.install("Maps");
        System.out.println("_".repeat(60));

        AbstractPhone firstPhone = new ThomasEdisonPhone(1879);
        AbstractPhone phone = new Phone(1984);
        AbstractPhone videoPhone = new VideoPhone(2018);
        User user = new User("Андрей");
        user.callAnotherUser("224466", firstPhone);
// Вращайте ручку
//Сообщите номер абонента, сэр
        user.callAnotherUser("224466", phone);
//Вызываю номер 224466
        user.callAnotherUser("224466", videoPhone);
//Подключаю видеоканал для абонента 224466
    }
}

class SomePhone {
    private int year;
    private String company;

    public SomePhone(int year, String company) {
        this.year = year;
        this.company = company;
    }

    private void openConnection() {
        System.out.println("Соединение устанавливается");
    }

    public void call(String outNumber) {
        openConnection();
        System.out.print("Вызываю номер: ");
    }

    public void ring() {
        System.out.println("Дзынь-дзынь");
    }
}

abstract class AbstractPhone {
    private int year;

    public AbstractPhone(int year) {
        this.year = year;
    }

    public abstract void call(String outputNumber);

    public abstract void ring(String inputNumber);
}

abstract class WirelessPhone extends AbstractPhone {
    private int hour;

    public WirelessPhone(int year, int hour) {
        super(year);
        this.hour = hour;
    }
}

class CellPhone extends WirelessPhone {
    public CellPhone(int year, int hour) {
        super(year, hour);
    }

    @Override
    public void call(String outputNumber) {
        System.out.println("Вызываю номер: " + outputNumber);
    }

    @Override
    public void ring(String inputNumber) {
        System.out.println("Вам звонит абонент: " + inputNumber);
    }
}

class SmartPhone extends CellPhone {
    private String operationSystem;

    public SmartPhone(int year, int hour, String operationSystem) {
        super(year, hour);
        this.operationSystem = operationSystem;
    }

    public void install(String program) {
        System.out.println("Устанавливаю " + program + " для " + operationSystem);
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void callAnotherUser(String number, AbstractPhone phone) {
        phone.call(number);
    }
}

class ThomasEdisonPhone extends AbstractPhone {

    public ThomasEdisonPhone(int year) {
        super(year);
    }

    @Override
    public void call(String outputNumber) {
        System.out.println("Вращайте ручку");
        System.out.println("Сообщите номер абонента, сэр");
    }

    @Override
    public void ring(String inputNumber) {
        System.out.println("Телефон звонит");
    }
}

class Phone extends AbstractPhone {

    public Phone(int year) {
        super(year);
    }

    @Override
    public void call(String outputNumber) {
        System.out.println("Вызываю номер: " + outputNumber);
    }

    @Override
    public void ring(String inputNumber) {
        System.out.println("Телефон звонит: ");
    }
}

class VideoPhone extends AbstractPhone {

    public VideoPhone(int year) {
        super(year);
    }

    @Override
    public void call(String outputNumber) {
        System.out.println("Подключаю видеоканал для абонента: " + outputNumber);
    }

    @Override
    public void ring(String inputNumber) {
        System.out.println("У вас входящий видеовызов..." + inputNumber);
    }
}