package chars;

public class CharTest {
    public static void main(String[] args) {
        int i = 29;
        System.out.println(charExpression(i));
        System.out.println((int) '\\' + " " + (int) 'f');
        char x = 50;
        System.out.println(x);
        System.out.println(((Object)x).getClass().getSimpleName());
    }

    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }
}
