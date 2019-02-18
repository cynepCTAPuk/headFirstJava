//: typeinfo/toys/ToyTest.java
// Testing class Class.
package chap14_typeinfo.toys;
import static util.Print.*;
interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
interface Jump {}

class Toy {
    // Comment out the following default constructor
    // to see NoSuchMethodError from (*1*)
    Toy() {}
    Toy(int i) {}
}
class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, Jump {
    FancyToy() { super(1); }
}
public class ToyTest {
    static void printInfo(Class cc) {
        print("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        print("Simple name: " + cc.getSimpleName());
        print("Canonical name : " + cc.getCanonicalName() + "\n");
    }
    public static void main(String[] args) {
        Class c = null;
        try { c = Class.forName("chap14_typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            print("Can’t find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces()) printInfo(face);
        Class up = c.getSuperclass();
        Object obj = null;
        try { obj = up.newInstance(); // Requires default constructor:
        } catch (InstantiationException e) {
            print("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            print("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
} /* Output:
Class name: chap14_typeinfo.toys.FancyToy is interface? [false]
Simple name: FancyToy
Canonical name : chap14_typeinfo.toys.FancyToy
Class name: chap14_typeinfo.toys.HasBatteries is interface? [true]
Simple name: HasBatteries
Canonical name : chap14_typeinfo.toys.HasBatteries
Class name: chap14_typeinfo.toys.Waterproof is interface? [true]
Simple name: Waterproof
Canonical name : chap14_typeinfo.toys.Waterproof
Class name: chap14_typeinfo.toys.Shoots is interface? [true]
Simple name: Shoots
Canonical name : chap14_typeinfo.toys.Shoots
Class name: chap14_typeinfo.toys.Toy is interface? [false]
Simple name: Toy
Canonical name : chap14_typeinfo.toys.Toy
*///:~