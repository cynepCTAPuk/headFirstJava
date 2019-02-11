//: enumerated/OzWitch.java
// The witches in the land of Oz.
package chap19_enumerated;
import java.util.*;

import static util.Print.*;

public enum OzWitch {
    // Instances must be defined first, before methods:
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby " +
            "Slippers, crushed by Dorothy’s house"),
    SOUTH("Good by inference, but missing");
    private String description;

    // Constructor must be package or private access:
    private OzWitch(String description) { this.description = description; }

    public String getDescription() { return description; }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) print(witch + ":\t" + witch.getDescription());
        System.out.println(Arrays.toString(OzWitch.values()));
    }
} /* Output:
WEST: Miss Gulch, aka the Wicked Witch of the West
NORTH: Glinda, the Good Witch of the North
EAST: Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy’s house
SOUTH: Good by inference, but missing
*///:~