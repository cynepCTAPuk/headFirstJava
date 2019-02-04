package chap07_reusing;
import static util.Print.print;

// Making an entire class final.
class SmallBrain {}
final class Dinosaur {
    int i = 7;
    int j = 1;
    SmallBrain x = new SmallBrain();
    void f() {print("Dinosaur f()");}
}
//class Further extends Dinosaur {}
// error: Cannot extend final class ‘Dinosaur’
public class Jurassic {
    public static void main(String[] args) {
        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 40;
        n.j++;
        Dinosaur n1 = new Dinosaur();
    }
} ///:~