package test;

public class Callback {
    interface MyCallback {
        void callBackReturn();
    }

    MyCallback myCallback;

    void registerCallBack(MyCallback callback) {
        this.myCallback = callback;
    }

    void doSomething() {
        // Здесь какой-то длительный код
        // Например, тянем кота за хвост

        // вызываем метод обратного вызова
        myCallback.callBackReturn();
    }

    public static void main(String[] args) {
        Callback callback = new Callback();
        callback.doSomething();
    }
}