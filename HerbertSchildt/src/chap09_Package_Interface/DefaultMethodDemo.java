package chap09_Package_Interface;

public class DefaultMethodDemo {
    public static void main(String[] args) {
        MyIFimp obj = new MyIFimp();
        // Can call getNumber(), because it is explicitly implemented by MyIFImp:
        System.out.println(obj.getNumber());

        // Can also call getString(), because of default implemention:
        System.out.println(obj.getString());
        System.out.println(MyIF.getDefaultNumber());
    }
}
