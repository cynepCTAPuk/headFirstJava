package logical.task3013;

/* 
Набираем код
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int number = Integer.MAX_VALUE - 133;
        int number = 3456; // 2048
//        int number = 255; //128
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
        //напишите тут ваш код
        number = number | (number >> 1);
        number = number | (number >> 2);
        number = number | (number >> 4);
        number = number | (number >> 8);
        number = number | (number >> 16);
        number = number | (number >> 32);
        number = number & ~(number >> 1);
        return number;
//        return 1 << Integer.toString(number, 2).length() >>> 1;
//        return number >> Integer.toString(number, 2).length() - 1 << Integer.toString(number, 2).length() - 1;
    }
}