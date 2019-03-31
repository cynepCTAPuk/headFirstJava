package beginning;

public class ClassGetName {
    public static void main(String[] args) throws Exception {

        String name;

        name = boolean[].class.getName();
        System.out.println(name);
        name = char[].class.getName();
        System.out.println(name);

        name = byte[].class.getName();
        System.out.println(name);
        name = short[].class.getName();
        System.out.println(name);
        name = int[].class.getName();
        System.out.println(name);
        name = long[].class.getName();
        System.out.println(name);

        name = int[][].class.getName();
        System.out.println(name);

        name = float[].class.getName();
        System.out.println(name);
        name = double[].class.getName();
        System.out.println(name);

        name = String[].class.getName();
        System.out.println(name);
    }
}