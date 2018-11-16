package chap01;
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

import utils.Utils;

public class SimpleStockSpan {
  public static void main(String[] args) {
    int n = 10;
    int[] quotes = new int[n];
    int[] spans1 = new int[n];
    int[] spans2 = new int[n];
    Utils.fillRandom(quotes);

//    spans1[0] =0;
    for (int i = 0; i < n; i++) {
      int k = 1;
      boolean span_end = false;
      while (((i - k) >= 0) & !span_end) {
        if (quotes[i - k] <= quotes[i]) k = k + 1;
        else span_end = true;
        spans1[i] = k;
      }
    }
    spans2[0] = 0;
    for (int i = 1; i < n; i++) {
      if (quotes[i] >= quotes[i - 1]) spans2[i] = spans2[i - 1] + 1;
      else spans2[i] = 1;
    }
    Utils.print(quotes);
    Utils.print(spans1);
    Utils.print(spans2);

/*
    Utils.printForEach(spans1);
    Integer[] quotesInt = IntStream.of(quotes).boxed().toArray(Integer[]::new);
    Integer[] spansInt = IntStream.of(spans1).boxed().toArray(Integer[]::new);
    Utils.printForEach(quotesInt);
    Utils.printForEach(spansInt);
*/
  }
}
