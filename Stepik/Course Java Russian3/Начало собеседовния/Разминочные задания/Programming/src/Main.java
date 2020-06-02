public class Main {
    public void fizzBuzzPrint(int i) {
        String result = "";
        if (i % 3 == 0) result += "Fizz";
        if (i % 5 == 0) result += "Buzz";
        if (result.length() == 0) System.out.print(i);
        else System.out.print(result);
    }

}
