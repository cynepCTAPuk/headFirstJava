package chap09_Package_Interface.p1;

//    Instantiate the various classes in p1.
public class Demo {
    public static void main(String[] args) {
        Protection ob1 = new Protection();
        System.out.println();
        Derived ob2 = new Derived();
        System.out.println();
        SamePackage ob3 = new SamePackage();
    }
}
