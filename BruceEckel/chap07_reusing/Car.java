package chap07_reusing;

import static util.Print.print;

//: reusing/Car.java
// Composition with public objects.
class Engine {
    public void start() {print("Start");}
    public void rev() {print("Reverse");}
    public void stop() {print("Stop");}
    public void service() {print("Service");}
}
class Wheel {
    public void inflate(int psi) {print("Inflate "+psi+" psi");}
}
class Window {
    public void rollup() {print("Rollup");}
    public void rolldown() {print("Rolldown");}
}
class Door {
    public Window window = new Window();
    public void open() {print("Open door");}
    public void close() {print("Close door");}
}
public class Car {
    public Engine engine = new Engine();
    public Wheel[] wheel = new Wheel[4];
    public Door
            left = new Door(),
            right = new Door(); // 2-door
    public Car() {
        for(int i = 0; i < 4; i++)
            wheel[i] = new Wheel();
    }
    public static void main(String[] args) {
        Car car = new Car();
        car.left.window.rollup();
        car.wheel[0].inflate(72);
        car.engine.service();
    }
} ///:~