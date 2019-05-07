package chap08_template_method;

abstract class AbstractClassWithHook {
    final void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        concreteOperation();
        hook();
    }

    abstract void primitiveOperation1();

    abstract void primitiveOperation2();

    final void concreteOperation() {
//        реализация
    }

    void hook() {
//        Конкретный метод, который не делает ничего
    }
}