package chap12_Enums_Annotations;

public class EnumDemo {
    public static void main(String[] args) {
        Apple1 apple;
        apple = Apple1.RedDel;
        // Output an enum value
        System.out.println("Value of apple: " + apple);
        System.out.println();

        apple = Apple1.GoldenDel;
        // Compare two enum values
        if (apple == Apple1.GoldenDel)
            System.out.println("apple contains GoldenDel\n");

        //Use an enum to control a switch statement
        switch (apple) {
            case Jonathan:
                System.out.println("Jonathan is red");
                break;
            case GoldenDel:
                System.out.println("Golden Delicious is yellow");
                break;
            case RedDel:
                System.out.println("RedDel Delicious is red");
                break;
            case Winesap:
                System.out.println("Winesap is red");
                break;
            case Cortland:
                System.out.println("Cortland is red");
                break;
        }
    }
}
