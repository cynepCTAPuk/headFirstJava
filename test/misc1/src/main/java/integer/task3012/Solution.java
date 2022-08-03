package integer.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(1234);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        System.out.print(number+" = ");
        int[] ints = new int[]{1, 3, 9, 27, 81, 243, 729, 2187};
        for (int i : ints) {
            if (number + number > i)
                number += i;
        }
        String s = Integer.toString(number, 3);
        s = s.replace('0', '-');
        s = s.replace('1', '0');
        s = s.replace('2', '+');
        char[] charArray = s.toCharArray();
        for (int j = charArray.length - 1; j >= 0; j--) {
            char c = charArray[j];
            if (c != '0') System.out.print(" " + c + " " + ints[charArray.length - j - 1]);
        }
    }
}