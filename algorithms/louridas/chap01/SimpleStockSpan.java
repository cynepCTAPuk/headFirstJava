package louridas.chap01;
/*
 *
 * <p>Алгоритм 1.1. Простой алгоритм для задачи о разнице курсов акций</p>
 *
 * part1.SimpleStockSpan(quotes)→spans
 * Input: quotes, an array with n stock price quotes
 * Output: spans, an array with n stock price spans
 * 1 spans ←CreateArray(n)
 * 2 for i ←0 to n do
 * 3 k ←1
 * 4 span_end ←false
 * 5 while i −k ≥ 0 and not span_end do
 * 6 if quotes[i −k] ≤ quotes[i] then
 * 7 k ←k + 1
 * 8 else
 * 9 span_end ←true
 * 10 spans[i] ←k
 * 11 return spans
 *
 */

import tools.Utils;

import java.util.Stack;

public class SimpleStockSpan {
  public static void main(String[] args) {
    int n = 20;
    int[] quotes = new int[n];
//    int[] quotes = new int[]{7, 11, 8, 6, 3, 8, 9};
    Utils.fillRandom(quotes);
    long starTime;


    starTime = System.nanoTime();
    int[] spans1 = new int[n];
    for (int i = 0; i < n; i++) {
      int k = 1;
      boolean span_end = false;
      while (((i - k) >= 0) && !span_end) {
        if (quotes[i - k] <= quotes[i]) k = k + 1;
        else span_end = true;
        spans1[i] = k;
      }
    }
    double tSpans1 = System.nanoTime() - starTime;

    starTime = System.nanoTime();
    int[] spans2 = new int[n]; // 1
    spans2[0] = 1; // 2
    Stack<Integer> stack = new Stack<>(); // 3
    stack.push(0); // 4
    for (int i = 1; i < n; i++) { // 5
      while (!stack.empty() && (quotes[stack.peek()] <= quotes[i])) stack.pop(); // 6-7
      if (stack.empty()) spans2[i] = i + 1; // 8-9
      else spans2[i] = i - stack.peek(); // 10-11
      stack.push(i); // 12
    }
    double tSpans2 = System.nanoTime() - starTime;

    Utils.print(quotes);
    Utils.print(spans1);
    Utils.print(spans2);
    System.out.println(String.format("tSpans1\ttime nanoseconds\t%,.0f", tSpans1));
    System.out.println(String.format("tSpans2\ttime nanoseconds\t%,.0f", tSpans2));

/*
    Integer[] quotesInt = IntStream.of(quotes).boxed().toArray(Integer[]::new);
    Integer[] spansInt = IntStream.of(spans1).boxed().toArray(Integer[]::new);
*/
  }
}
