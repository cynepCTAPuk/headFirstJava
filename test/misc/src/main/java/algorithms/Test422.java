package algorithms;

import java.util.*;

/**
 * Stepik: кодирование Хаффмана
 * По данной непустой строке ss длины не более 10^4, состоящей из строчных букв
 * латинского алфавита, постройте оптимальный беспрефиксный код.
 * В первой строке выведите количество различных букв kk, встречающихся в строке,
 * и размер получившейся закодированной строки. В следующих kk строках запишите коды букв
 * в формате "letter: code". В последней строке выведите закодированную строку.<p>
 * Sample Input 1:<p>
 * a<p>
 * Sample Output 1:<p>
 * 1 1<p>
 * a: 0<p>
 * 0<p>
 * Sample Input 2:<p>
 * abacabad<p>
 * Sample Output 2:<p>
 * 4 14<p>
 * a: 0<p>
 * b: 10<p>
 * c: 110<p>
 * d: 111<p>
 * 01001100100111
 */
public class Test422 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
//        String[] numbers = data.split(" ");
        Map<String, String> map = new TreeMap<>();
        String line = scanner.nextLine();
        while (line.contains(":")) {
            String[] strings = line.split(":");
            map.put(strings[1].trim(), strings[0]);
            line = scanner.nextLine();
        }
        System.out.println(map);


    }
}