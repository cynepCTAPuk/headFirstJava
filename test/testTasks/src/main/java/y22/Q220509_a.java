package y22;

class Q220509_b {
    private Q220509_b() {
        System.out.println("private");
    }

    protected Q220509_b(String str) {
        System.out.println("protected");
    }
}

public class Q220509_a extends Q220509_b {
    public Q220509_a() {
        this("something");
    }

    public Q220509_a(String str) {
        super(str);
    }

    public static void main(String[] args) {
        Q220509_a q220509_a = new Q220509_a();
    }

}
