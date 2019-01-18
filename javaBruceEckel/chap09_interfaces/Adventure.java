package chap09_interfaces;

import static util.Print.print;

//: interfaces/Adventure.java
// Multiple interfaces.
interface CanFight { void fight(); }
interface CanSwim { void swim(); }
interface CanFly { void fly(); }
interface CanClimb { void climb(); }

class ActionCharacter { public void fight() {print("fight");} }
class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly, CanClimb {
    public void swim() {print("swim");}
    public void fly() {print("fly");}
    public void climb() {print("climb");}
}
public class Adventure {
    public static void t(CanFight x) { x.fight(); }
    public static void u(CanSwim x) { x.swim(); }
    public static void v(CanFly x) { x.fly(); }
    public static void w(CanClimb x) { x.climb(); }
    public static void x(ActionCharacter x) { x.fight(); }

    public static void main(String[] args) {
        Hero h = new Hero();
        t(h); // Treat it as a CanFight
        u(h); // Treat it as a CanSwim
        v(h); // Treat it as a CanFly
        w(h);
        x(h); // Treat it as an ActionCharacter
    }
} ///:~