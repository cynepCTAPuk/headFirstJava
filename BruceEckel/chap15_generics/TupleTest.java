//: generics/TupleTest.java
package chap15_generics;
import util.*;
class Amphibian {}
class Vehicle {}
public class TupleTest {
    // Autoboxing converts the int to Integer:
    static TwoTuple<String,Integer> f() {
        return new TwoTuple<>("hi", 47); }
    static ThreeTuple<Amphibian,String,Integer> g() {
        return new ThreeTuple<>(new Amphibian(), "hi", 47); }
    static FourTuple<Vehicle,Amphibian,String,Integer> h() {
        return new FourTuple<>( new Vehicle(), new Amphibian(), "hi", 47); }
    static FiveTuple<Vehicle,Amphibian,String,Integer,Double> k() {
        return new FiveTuple<>( new Vehicle(), new Amphibian(), "hi", 47, 11.1); }

    public static void main(String[] args) {
        TwoTuple<String,Integer> ttsi = f();
        System.out.println(ttsi);
        // ttsi.first = "there"; // Compile error: final
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
} /* Output: (80% match)
(hi, 47)
(Amphibian@1f6a7b9, hi, 47)
(Vehicle@35ce36, Amphibian@757aef, hi, 47)
(Vehicle@9cab16, Amphibian@1a46e30, hi, 47, 11.1)
*///:~