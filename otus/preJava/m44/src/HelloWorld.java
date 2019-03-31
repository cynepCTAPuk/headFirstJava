public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {
        String string = "Hello World!";
        for (int i = 0; i < string.length(); i++) {
            Thread.sleep(100);
            System.out.print(string.charAt(i));
        }

        System.out.println();

        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Thread.sleep(100);
            System.out.print(chars[i]);
        }
    }
}
