package string.task2702;

/* 
Нужный оператор
*/
public class Solution {
    public static void main(String[] args) {
        label:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > i) {
                    System.out.println();
                    continue label;
//                    break label;
                }
                System.out.print("S");
            }
        }
    }
}
