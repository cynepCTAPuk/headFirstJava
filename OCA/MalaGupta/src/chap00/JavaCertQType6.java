package chap00;

/*
Select incorrect options (choose 2):
Code will compile successfully only if code on line 3 is commented.
Code will output the same result if access modifier of main() is changed to public at line 6.
Code will compile successfully and execute without any runtime exceptions.
If the order of code on lines 3 and 4 is reversed, the code won't output 'EJavaGuru'.
 */
public class JavaCertQType6 {
    public static void main(String... method) {
        main();         // line 3
        main(method);   // line 4
    }

    protected static void main() {  // line 6
        System.out.println("EJavaGuru");
    }
}
