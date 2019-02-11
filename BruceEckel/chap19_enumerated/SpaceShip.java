//: enumerated/SpaceShip.java
package chap19_enumerated;

import java.util.*;

public enum SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }
    public static void main(String[] args) {
        for(SpaceShip s : values()) { System.out.println(s); }
        System.out.println(Arrays.toString(values()));
    }
} /* Output:
Scout
Cargo
Transport
Cruiser
Battleship
Mothership
*///:~