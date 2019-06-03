package chap00;
/*
Which of the following options can be used to define a main method that
outputs the value of the second and fourth command parameters (choose 2):

public static void main(String... method) {
    for (int i = 1; i < method.size && i < 6; i = i + 2)
    System.out.println(method[i]);
}
public static void main(String[] main) {
    for (int i = 1; i < main.length && i < 6; i = i + 2)
    System.out.println(main[i]);
}
public static void main(String... arguments) {
    int ctr = 0;
    while (ctr < arguments.length) {
        if (ctr >= 4) break;
        if (ctr %2 != 0)
        System.out.println(arguments[ctr]);
        ++ctr;
    }
}
public static void main(String[] arguments) {
    int ctr = 1;
    while (ctr < arguments.length) {
        if (ctr >= 4) break;
        if (ctr %2 == 0)
        System.out.println(arguments[ctr]);
        ++ctr;
    }
}
*/
public class JavaCertQType7 {
}