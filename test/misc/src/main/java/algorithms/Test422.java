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
        Map<String, String> map = new HashMap<>();
        String line = readData(map);
        System.out.println(decodeFromTableHuffman(line, map));
    }

    public static String readData(Map<String, String> output) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String line = scanner.nextLine();
        while (line.contains(":")) {
            String[] word = line.split(":");
            output.put(word[1].trim(), word[0]);
            line = scanner.nextLine();
        }
        return line;
    }

    public static String decodeFromTableHuffman(String codeHuffman, Map<String, String> table) {
        char[] chars = codeHuffman.toCharArray();
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (i < chars.length) {
            String code = "" + chars[i++];
            while (!table.containsKey(code) && i < chars.length) {
                code += chars[i++];
            }
            result.append(table.get(code));
        }
        return result.toString();
    }
}