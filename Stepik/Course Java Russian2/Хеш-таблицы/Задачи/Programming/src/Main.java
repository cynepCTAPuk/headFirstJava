import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
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
