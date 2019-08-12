package chap12_Enums_Annotations;

public class AutoBox3b {
    public static void main(String[] args) {
        Integer iOb= 2;
        switch (iOb) {
            case 1:
                System.out.println("onw");
                break;
            case 2:
                System.out.println("two");
                break;
            default:
                System.out.println("Error!");
        }
    }
}
