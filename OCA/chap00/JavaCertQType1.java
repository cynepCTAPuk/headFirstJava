package chap00;
/*
What is the output when class JavaCertQType1 is executed using
the following command (choose 1 option):
java JavaCertQType1 1 11 EJava Guru
1
1 11
111
12
1 11 EJava Guru
Compilation error
Runtime exception
 */
class JavaCertQType1 {
    public static void main(String... cmd) {
        main("private", cmd);
    }
    private static void main(String type, String[] args) {
        System.out.println(args[0] + args[1]);
    }
}