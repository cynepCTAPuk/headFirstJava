package integer.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            if (args.length == 0) {
                System.out.println("Input don't have symbols");
            } else if (args.length > 255) {
                System.out.println("Input is over 255 symbols");
            } else {
                String input = args[0].toLowerCase();
                String digits = "0123456789abcdefghijklmnopqrstuvwxyz";

                int maxChar = 1;
                for (int i = 0; i < input.length(); i++) {
                    if (!digits.contains(input.substring(i, i + 1))) {
                        maxChar = -1;
                        break;
                    }
                    int idx = digits.indexOf(input.charAt(i));
                    if (idx > maxChar) maxChar = idx;
                }
                if (maxChar == -1) System.out.println("incorrect");
                else System.out.println(maxChar + 1);
            }
        } catch (Exception ignored) {
        }
    }
}
