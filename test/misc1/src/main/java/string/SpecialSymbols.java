package string;

public class SpecialSymbols {
    static String moveAllSpecialSymbolsToEnd(String str) {
        int len = str.length();
        String regX = "[a-zA-Z0-9\\s+]";
        String result1 = "";
        String result2 = "";
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (String.valueOf(c).matches(regX)) result1 += c;
            else result2 += c;
        }
        return result1 + " | " + result2;
    }

    public static void main(String[] args) {
        String str = "J!@av@a :i!@@s th#$e %b^est p****rogramming l#a@ngua$ge";
        System.out.println(moveAllSpecialSymbolsToEnd(str));
    }
}
