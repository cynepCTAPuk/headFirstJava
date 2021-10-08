package aaa;

public class IntTest {
    public static void main(String[] args) {
        Request request = new Request();
        request.setNumber(0xaf);
        System.out.printf("%s %s%n", getString(request, 2), getString(request, 10));
    }

    private static String getString(Request request, int i) {
        return Integer.toString(request.getNumber(), i);
    }
}

class Request {
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}