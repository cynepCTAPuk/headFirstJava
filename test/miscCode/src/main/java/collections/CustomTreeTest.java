package collections;

import java.util.List;

public class CustomTreeTest {
    public static void main(String[] args) {
        List<String> list = new CustomTree();

        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        ((CustomTree) list).printAll();
        System.out.println("The list size is " + list.size());
        System.out.println("The expected parent is 3. The actual parent is " + ((CustomTree) list).getParent("8"));
        System.out.println("The expected parent is null. The actual parent is " + ((CustomTree) list).getParent("20"));

        list.remove("3");
        System.out.println("remove 3");
        System.out.println("The list size is " + list.size());
        System.out.println("The expected parent is null. The actual parent is " + ((CustomTree) list).getParent("8"));
        ((CustomTree) list).printAll();

        list.add("16");
        System.out.println("The expected parent is 9. The actual parent is " + ((CustomTree) list).getParent("16"));
        ((CustomTree) list).printAll();

        list.remove("4");
        System.out.println("remove 4");
        System.out.println("The list size is " + list.size());
        list.remove("5");
        System.out.println("remove 5");
        System.out.println("The list size is " + list.size());
        list.remove("6");
        System.out.println("remove 6");
        System.out.println("The list size is " + list.size());
        ((CustomTree) list).printAll();

        System.out.println("Expected: true. Actual: " + list.add("20"));
        ((CustomTree) list).printAll();
        System.out.println("The expected parent is 1. The actual parent is " + ((CustomTree) list).getParent("20"));
        System.out.println("The list size is " + list.size());
    }
}
