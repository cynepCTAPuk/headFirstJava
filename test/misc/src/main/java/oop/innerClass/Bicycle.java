package oop.innerClass;

public class Bicycle {
    private String model;
    private int mawWeight;

    public Bicycle(String model, int mawWeight) {
        this.model = model;
        this.mawWeight = mawWeight;
    }

    public void start() {
        System.out.println("Поехали!");
    }

    class Seat {
        public void up() {
            System.out.println("Сидение поднято выше!");
        }

        public void down() {
            System.out.println("Сидение опущено ниже!");
        }
    }

    class SportSeat extends Seat {
        //...методы
    }
}