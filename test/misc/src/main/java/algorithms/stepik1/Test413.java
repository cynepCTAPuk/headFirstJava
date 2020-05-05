package algorithms.stepik1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Stepik: различные слагаемые<p>
 * По данному числу 1 ≤ n ≤ 10^9 найдите максимальное число k, для которого n
 * можно представить как сумму k различных натуральных слагаемых.
 * Выведите в первой строке число k, во второй — k слагаемых.<p>
 * Sample Input 1:<p>
 * 4<p>
 * Sample Output 1:<p>
 * 2<p>
 * 1 3<p>
 * Sample Input 2:<p>
 * 6<p>
 * Sample Output 2:<p>
 * 3<p>
 * 1 2 3
 */
public class Test413 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int i = 1;
        while (sum < n) {
            list.add(i);
            sum += i;
            i++;
        }
//        System.out.println(list);
        if (sum > n) {
            sum -= list.get(list.size() - 1);
            list.remove(list.size() - 1);
            sum -= list.get(list.size() - 1);
            list.remove(list.size() - 1);
            list.add(n - sum);
        }
        System.out.println(list.size());
        list.forEach(x -> System.out.print(x + " "));
    }
}