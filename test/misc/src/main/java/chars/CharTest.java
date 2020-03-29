package chars;

public class CharTest {
    public static void main(String[] args) {
        int i = 29;
        System.out.println(charExpression(i));
        System.out.println((int) '\\' + " " + (int) 'f');
    }

    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }
}
