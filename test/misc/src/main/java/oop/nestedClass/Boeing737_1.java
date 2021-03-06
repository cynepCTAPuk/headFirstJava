package oop.nestedClass;

public class Boeing737_1 {
    private int manufactureYear;
    private static int maxPassengersCount = 300;

    public Boeing737_1(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public static class Drawing {
    }

    public static class Boeing737Drawing extends Drawing {
        public static int getMaxPassengersCount() {
            return maxPassengersCount;
        }
    }
}
