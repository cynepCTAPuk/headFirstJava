package aaa;

public class IntTest {
    public static void main(String[] args) {
        Request request = new Request();
        System.out.println(Integer.toString(request.getNumber()));
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