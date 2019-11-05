/**
 * 3.6. Преобразование строк в потоки и наоборот
 * Проблема:
 * Требуется более идиоматичный способ обработки строк, чем цикл по отдельным символам.
 * Решение:
 * Использовать методы по умолчанию chars и codePoints интерфейса java.lang.CharSequence для преобразования
 * String в IntStream. Для обратного преобразования потока в строку использовать перегруженный
 * вариант метода collect из интерфейса IntStream, который принимает поставщик Supplier,
 * объект BiConsumer, представляющий аккумулятор, и объект BiConsumer, представляющий комбинатор.
 */
package chap03_streams;

public class StringToStreamDemo {
    public static void main(String[] args) {
        StringToStreamDemo demo = new StringToStreamDemo();
        System.out.println(demo.isPalindromeBefore("abba"));
    }

    public boolean isPalindromeBefore(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) sb.append(c);
        }
        String forward = sb.toString().toLowerCase();
        String backward = sb.reverse().toString().toLowerCase();
        return forward.equals(backward);
    }

    public boolean isPalindrome(String s) {
        String forward = s.toLowerCase()
                .codePoints() //  Возвращается IntStream
                .filter(Character::isLetterOrDigit)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
        String backward = new StringBuilder(forward).reverse().toString();
        return forward.equals(backward);
    }

}
