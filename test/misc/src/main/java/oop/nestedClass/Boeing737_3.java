package oop.nestedClass;

public class Boeing737_3 {
    private int manufactureYear;
    private static int maxPassengersCount = 300;

    public Boeing737_3(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public static class Drawing {
    }

    public class Boeing737Drawing extends Drawing {
        public int getMaxPassengersCount() {
            return maxPassengersCount;
        }
    }
}
