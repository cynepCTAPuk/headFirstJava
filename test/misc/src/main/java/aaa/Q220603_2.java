package aaa;

public class Q220603_2 {
    public static void main(String[] args) {
        p1:
        {
            p2:
            {
                p3:
                {
                    System.out.println("p3.1 ");
                    if (true) break p2;
                    System.out.println("p3.2 ");
                }
                System.out.println("p2 ");
            }
            System.out.println("p1 ");
        }
    }
}