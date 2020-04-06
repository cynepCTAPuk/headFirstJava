// You can experiment here, it won’t be checked

class Task {
    public static void main(String[] args) {
        // put your code here
        System.out.println("A" + ('\t' + '\u0003'));

        System.out.println();
        System.out.println('A');
        System.out.println('A' + '1');
        System.out.println('A' + '1' + "2");

        System.out.println();
        System.out.println('A' + "12");
        System.out.println("A" + 12);

        int[] arr = {};
        System.out.println(arr.length);
        int[] array = new int[0];
        System.out.println(array.length);

        System.out.println(isPalindrome("Madam, I'm Adam!"));
        System.out.println(isPalindrome(null));
    }

    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {
        if (text == null) return false;
        if (text.length() == 0 || text.length() == 1) return true;
        System.out.println(text);
        StringBuilder sb = new StringBuilder(text.toLowerCase().replaceAll("[^a-z0-9]", ""));
        System.out.println(sb);
        return sb.toString().equals(sb.reverse().toString());
    }
}
