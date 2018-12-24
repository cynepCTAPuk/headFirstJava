package chap01;

public class Square extends Shape {
    @Override
    void draw() {
//        super.draw();
        System.out.println("Draw square");
    }

    @Override
    void erase() {
//        super.erase();
        System.out.println("Erase square");
    }
}
