package chap04_1_factory_method.simple_pizza_factory;

abstract class Pizza {
    void prepare() {
        System.out.print("Prepare ");
    }
    void bake() {
        System.out.print("Bake ");
    }
    void cut() {
        System.out.print("Cut ");
    }
    void box() {
        System.out.print("Box\n");
    }
}
