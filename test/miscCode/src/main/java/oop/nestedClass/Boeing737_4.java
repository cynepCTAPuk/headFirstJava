package oop.nestedClass;

public class Boeing737_4 {
    private int manufactureYear;
    public static int maxPassengersCount = 300; // should be public

    public Boeing737_4(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public static class Drawing {
    }


}

class Boeing737Drawing extends Boeing737_4.Drawing {
    public static int getMaxPassengersCount() {
        return Boeing737_4.maxPassengersCount;
    }
}