package chap01;

class Triangle extends Shape {
    @Override
    void draw() {
//        super.draw();
        System.out.println("Draw triangle");
    }

    @Override
    void erase() {
        super.erase();
        System.out.println("Erase triangle");
    }

    void flipVertical() {

    }

    void flipHorizontal() {

    }
}
