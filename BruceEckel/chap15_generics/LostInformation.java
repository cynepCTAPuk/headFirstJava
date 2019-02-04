package chap15_generics;
//: generics/LostInformation.java
import java.util.*;
class Frob {}
class Fnorkle {}
class Quark<Q> {}
class Particle<POSITION, MOMENTUM> {}
public class LostInformation {
    public static void main(String[] args) {
        List<Frob> frobArrayList = new ArrayList<>();
        Map<Frob,Fnorkle> frobFnorkleHashMap = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Particle<Long,Double> particle = new Particle<>();
        System.out.println(Arrays.toString( frobArrayList.getClass().getTypeParameters()));
        System.out.println(Arrays.toString( frobFnorkleHashMap.getClass().getTypeParameters()));
        System.out.println(Arrays.toString( quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString( particle.getClass().getTypeParameters()));
    }
} /* Output:
[E]
[K, V]
[Q]
[POSITION, MOMENTUM]
*///:~