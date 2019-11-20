/**
 * \' single quote одинарная кавычка
 * \" double quote двайная кавычка
 * \\ backslash обратная косая черта
 * \n new line переход на новую строку
 * \r carriage return возврат каретки в начало строки
 * \t tab табуляция (4(четрые) пробела)
 * \b backspace удаление предыдущего символа и возврат каретки на один символ назад
 * \f form feed переход в начало следующий строки
 * \v vertical tab (Internet Explorer 9 and older treats '\v as 'v instead of a vertical tab ('\x0B).
 * If cross-browser compatibility is a concern, use \x0B instead of \v.)
 * \0 null character (U+0000 NULL)
 * (only if the next character is not a decimal digit; else it is an octal escape sequence)
 * \xFF character represented by the hexadecimal byte "FF"
 */
package unsort;

public class EscapeCharacter {
    public static void main(String[] args) throws InterruptedException {
        String s = "2 + 2 = 5";
        for (int i = 0; i < s.length(); i++) {
            Thread.sleep(1_000);
            System.out.print(s.substring(i, i + 1));
        }
        Thread.sleep(1_000);
        System.out.print("\b");
        Thread.sleep(1_000);
        System.out.println("4");

        System.out.print("Текст который необходимо переписать.");
        System.out.print('\r');//На экране пусто
        Thread.sleep(1_000);
        System.out.print("Новый текст.");
    }
}
