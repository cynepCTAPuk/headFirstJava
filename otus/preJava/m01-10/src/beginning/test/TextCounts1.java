package beginning.test;

import java.io.ByteArrayOutputStream;

public class TextCounts1 {

    public static void main(String[] args) {
        String str = "Привет тест. T..... a Тестирование 34. WHAT???";
        System.out.println(str);

        byte[] bytes = str.getBytes();
        byte tocka = '.'; //заставляем интерпретатор из символа точки получить 1 байт(можно цифру, но так понятнее вам будет)
        byte vopr = '?';
        byte voscl = '!';

        int count = 0; //храним количество
        int max = bytes.length;
        if (max > 0) {
            int i = 0; //сдвиг
            byte a; //активный байт
            //ДЕБАГ, В СЛУЧАЕ ИСПОЛЬЗОВАНИЯ СКРИПТА БЕЗ ДЕБАГА ЗАКОМЕНТИТЬ ОТ И ДО
            ByteArrayOutputStream out = new ByteArrayOutputStream(); //буфер для предложений
            //дебаг режим выводит уже предложения
            //РАЗБИРАЕМ
            while (i < max) { //ЦИКЛ ОСНОВА
                while (i < max) { //ЦИКЛ ПРЕРЫВАЕТСЯ ОЗНАЧАЮЩИЙ КОНЕЦ ПРЕДЛОЖЕНИЯ
                    a = bytes[i];
                    i = i + 1;

                    if (i < max) { //ЕСТЬ СИМВОЛЫ ДЛЯ ДЕБАГИНГА
                        if (a == tocka || a == vopr || a == voscl) { //ПРЕДЛОЖЕНИЕ.
                            //проверяем следующий символ
                            a = bytes[i];
                            i = i + 1;
                            if (i < max) {
                                if (a == tocka || a == vopr || a == voscl) { //возможно это троеточие, почемубы и нет? или ???:)
                                    while (i < max) {
                                        a = bytes[i];
                                        if (a != tocka && a != vopr && a != voscl) {
                                            break;
                                        }
                                        i = i + 1;
                                    }
                                }
                            }
                            break;
                        }
                    }
                    //ДЕБАГ
                    out.write(a);
                }
                count = count + 1; //ПРЕРЫВАНИЕ БЫЛО ИЛИ ПРЕДЛОЖЕНИЕ ОКОНЧЕНО ЗНАЧИТ ПРЕДЛОЖЕНИЕ
                //ДЕБАГ, МОЖНО ЗАКОМЕНТИТЬ
                System.err.println(out.toString());
                out.reset();
            }
        }
        System.out.println("Предложений по моему мнению:" + String.valueOf(count));
    }
}