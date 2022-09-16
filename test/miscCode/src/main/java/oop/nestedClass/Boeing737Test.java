package oop.nestedClass;

public class Boeing737Test {
    public static void main(String[] args) {

        Boeing737_2.Boeing737Drawing drawing2 = new Boeing737_2.Boeing737Drawing();
        System.out.println(Boeing737_2.Boeing737Drawing.getMaxPassengersCount());

        Boeing737_3 boeing737 = new Boeing737_3(1990);
        Boeing737_3.Boeing737Drawing drawing3 = boeing737.new Boeing737Drawing();
        System.out.println(drawing3.getMaxPassengersCount());
    }
}
