package algorithms.stepik2;

import util.Util;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Stepik Algorithm2: Телефонная книга<p>
 * Реализовать стуктуру данных, эффектисвно обрабатывающую запросы вида add number,
 * del number и find number.<p>
 * Вход: Последовательность запросов вида add number name, del number и find number,
 * где number - телефонный номер, содержащий не более семи знаков, а name - короткая строка.
 * Первая строка содержит число запросов n. Каждая из следующих n строк задаёт запрос в одном
 * из трёх описанных выше форматовю<p>
 * Выход: Для каждого запроса find number выведите соответствующее имя или сообщите,
 * что такой записи нет. Для каждого запроса find выведите в отдельной строке либо имя,
 * либо "not found".<p>
 * Ограничения: 1 <= n <= 10<sup>5</sup>. Телефонные номера содержать не более семи цифр
 * и не содержат ведущих нулей. Имена содержат только буквы латинского алфавита, не являются
 * пустыми строками и не имеют длину больше 15. Гарантируется, что среди имён не встречается
 * строка "not found".
 * <p>
 * Пример.<p>
 * Вход:<p>
 * 12<p>
 * add 911 police<p>
 * add 76213 Mom<p>
 * add 17239 Bob<p>
 * find 76213<p>
 * find 910<p>
 * find 911<p>
 * del 910<p>
 * del 911<p>
 * find 911<p>
 * find 76213<p>
 * add 76213 daddy<p>
 * find 76213<p>
 * Выход:<p>
 * Mom<p>
 * not found<p>
 * police<p>
 * not found<p>
 * Mom<p>
 * daddy
 */
public class Test321 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = scanner.nextLine();
        }
        Map<Integer, String> phoneBook = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = lines[i].split(" ");
            String command = input[0];
            int number = Integer.parseInt(input[1]);
            switch (command) {
                case "add":
                    String name = input[2];
                    phoneBook.put(number, name);
                    break;
                case "find":
                    String findName = phoneBook.get(number);
                    System.out.println(findName == null ? "not found" : findName);
                    break;
                case "del":
                    String removeName = phoneBook.remove(number);
                    break;
            }
        }
    }
}
