package oop.innerClass;

public class SportBicycle extends Bicycle {
    public SportBicycle(String model, int mawWeight) {
        super(model, mawWeight);
    }

    class SportSeat extends Seat {
        public void up() {
            System.out.println("Сидение поднято выше!");
        }

        public void down() {
            System.out.println("Сидение опущено ниже!");
        }
    }
}