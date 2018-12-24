package chap01;

class Circle extends Shape {
    @Override
    void draw() {
//        super.draw();
        System.out.println("Draw circle");
    }

    @Override
    void erase() {
//        super.erase();
        System.out.println("Erase circle");
    }
}
