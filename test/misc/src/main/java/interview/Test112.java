package interview;

/**
 * Палиндром
 * Палиндром - слово, которое одинаково читается в обоих направлениях.
 * Например:
 * 123454321
 * madam i’m Adam
 * Olson in Oslo
 * Необходимо реализовать функцию:
 * на вход функция получает строку;
 * нужно вывести в консоль слово yes, если строка является палиндромом;
 * нужно вывести в консоль слово no, если строка не является палиндромом;
 * при определении палиндрома игнорировать все пробелы, знаки препинания и апостроф.
 * Sample Input 1:
 * Madam i’m Adam
 * Sample Output 1:
 * yes
 * Sample Input 2:
 * Olson in Oslo
 * Sample Output 2:
 * yes
 */
public class Test112 {
    public static void main(String[] args) {
        checkPalindrom("Madam i’m ,Adam");
        checkPalindrom("Olson, in Oslof");
    }

    static void checkPalindrom(String s) {
        String a = s
                           .replaceAll(" ", "")
                           .replaceAll("\\p{Punct}", "")
                           .replaceAll("’", "");
        String b = new StringBuilder(a).reverse().toString();
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.equalsIgnoreCase(b) ? "yes" : "no");
    }

}
