package oop.innerClass;

class SportSeat extends Bicycle.Seat {
    public SportSeat(Bicycle bicycle) {
        bicycle.super();
    }

/*
    public void up() {
        System.out.println("Сидение поднято выше!");
    }

    public void down() {
        System.out.println("Сидение опущено ниже!");
    }
*/
}