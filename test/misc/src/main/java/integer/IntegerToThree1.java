package integer;

public class IntegerToThree1 {
    public static void main(String[] args) {
        IntegerToThree1 solution = new IntegerToThree1();
        solution.createExpression(1234);
    }

    public void createExpression(int number) {
        StringBuilder result = new StringBuilder().append(number).append(" =");
        String[] formats = {"", " + %,d", " - %,d"};
        int i = number;
        int tri = 1;
        while (i > 0) {
            result.append(String.format(formats[i % 3], tri));
            i = ++i / 3;
            tri *= 3;
        }
        System.out.println(result);

/*
        StringBuilder result = new StringBuilder().append(number).append(" =");
        String [] formats = {""," + %d"," - %d"};
        for (int i = number, tri = 1; 0 < i; i = ++i / 3, tri *= 3) {
            result.append(String.format(formats[i%3],tri));
        }
*/
    }
}

