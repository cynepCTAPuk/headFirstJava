import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String line = scanner.nextLine();
        Map<String, String> map = new HashMap<>();
        while (line.contains(":")) {
            String[] word = line.split(":");
            map.put(word[1].trim(), word[0]);
            line = scanner.nextLine();
        }
        System.out.println(decodeFromTableHuffman(line,map));
    }

    public static String decodeFromTableHuffman(String codeHuffman, Map<String, String> table) {
        char[] chars = codeHuffman.toCharArray();
        int index = 0;
        StringBuilder result = new StringBuilder();
        while (index < chars.length) {
            String code = "" + chars[index++];
            while (!table.containsKey(code) && index < chars.length) {
                code += chars[index++];
            }
            result.append(table.get(code));
        }
        return result.toString();
    }
}