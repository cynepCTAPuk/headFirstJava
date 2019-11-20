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

public class EscapeCharacter1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Лекция \"Экранирование символов\", \u00A9 2018 Javarush");
        System.out.println("\u041c\u0430\u0301\u043e " +
                "\u0426\u0437\u044d\u0434\u0443\u0301\u043d " +
                "\u0028\u043a\u0438\u0442\u002e \u0442\u0440\u0430\u0434\u002e " +
                "\u6bdb\u6fa4\u6771\u002c " +
                "\u0443\u043f\u0440\u002e " +
                "\u6bdb\u6cfd\u4e1c\u002c " +
                "\u043f\u0438\u043d\u044c\u0438\u043d\u044c\u003a " +
                "\u004d\u00e1\u006f " +
                "\u005a\u00e9\u0064\u014d\u006e\u0067\u0029 " +
                "\u2014 " + "\n" +
                "\u043a\u0438\u0442\u0430\u0439\u0441\u043a\u0438\u0439 " +
                "\u0433\u043e\u0441\u0443\u0434\u0430\u0440\u0441\u0442\u0432\u0435\u043d\u043d\u044b\u0439 " +
                "\u0438 " +
                "\u043f\u043e\u043b\u0438\u0442\u0438\u0447\u0435\u0441\u043a\u0438\u0439 " +
                "\u0434\u0435\u044f\u0442\u0435\u043b\u044c " +
                "\u0058\u0058 \u0432\u0435\u043a\u0430\u002c " +
                "\u0433\u043b\u0430\u0432\u043d\u044b\u0439 " +
                "\u0442\u0435\u043e\u0440\u0435\u0442\u0438\u043a " +
                "\u043c\u0430\u043e\u0438\u0437\u043c\u0430\u002e");
    }
}
