package create;

public class Main {
    public static void main(String[] args) {
        Bird c = new Crown();
        System.out.println(c);
        c.fly();

        Creature childCrow = c.reproduce();
        System.out.println(childCrow);
        ((Bird) childCrow).fly();
    }
}
