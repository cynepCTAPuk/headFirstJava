package nativ;
// https://habr.com/ru/company/jugru/blog/521672/

public class JavaToNative {
//    static native void goNative();

    static native void goThere(Callback andBackAgain);

    public static void main(String[] args) {
//        System.LoadLibrary("NativeLib");
        goThere(new Callback("Eagles"));
    }
}