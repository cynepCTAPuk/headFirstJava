package chap00;
/*
Select correct option (choose 2):
Code will compile successfully if code on line 6 is commented.
Code will output the same result if access modifier of main() is
changed to private at line 2.
Code won't compile if code on line 6 is placed after code on line 7.
The code compiles successfully, but throws a runtime exception.
 */
public class JavaCertQType5 {
    protected static void main() {
        System.out.println("EJavaGuru.com");
    }

    public static void main(String... method) {
        main();
        System.out.println("MissionOCAJ8");
    }
}
