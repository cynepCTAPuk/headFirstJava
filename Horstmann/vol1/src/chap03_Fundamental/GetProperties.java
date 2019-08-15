package chap03_Fundamental;

public class GetProperties {
    public static void main(String[] args) {
        String str = System.getProperties().toString();
//        System.out.println(str);

        String[] strings = str.split(", ");
        for(String string: strings) System.out.println(string);
    }
}
