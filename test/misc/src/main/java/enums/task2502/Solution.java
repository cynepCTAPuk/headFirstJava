package enums.task2502;

import java.util.LinkedList;
import java.util.List;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            //init wheels here
            wheels = new LinkedList<>();
            if (loadWheelNamesFromDB().length == 4) {
                for (String string : loadWheelNamesFromDB()) wheels.add(Wheel.valueOf(string));
            } else {
                throw new IllegalArgumentException();
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT_"};
        }
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(new Car().wheels);
    }
}
