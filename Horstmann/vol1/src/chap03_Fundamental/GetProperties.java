package chap03_Fundamental;

public class GetProperties {
    public static void main(String[] args) {
        String systemProperties = System.getProperties().toString();
//        System.out.println(systemProperties);
//        String[] strings = systemProperties.split(", ");
//        for(String string: strings) System.out.println(string);

        System.out.println(systemProperties.replace(", ", "\n"));
    }
}
