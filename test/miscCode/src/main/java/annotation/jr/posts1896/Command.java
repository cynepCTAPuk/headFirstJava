package annotation.jr.posts1896;
/**
 * https://javarush.ru/groups/posts/1896-java-annotacii-chto-ehto-i-kak-ehtim-poljhzovatjhsja
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Целью нашей Аннотации является метод (не класс, не переменная, не поле, а именно метод).
@Target(ElementType.METHOD)
//Аннотация может использована во время выполнения через Reflection (нам как раз это нужно).
@Retention(RetentionPolicy.RUNTIME)
//Описание. Заметим, что перед interface стоит @;
public @interface Command {
    //Команда за которую будет отвечать функция (например "привет");
    String name();

    //Аргументы команды, использоваться будут для вывода списка команд
    String args();

    //Минимальное количество аргументов, сразу присвоили 0 (логично)
    int minArgs() default 0;

    //Описание, тоже для списка
    String desc();

    //Максимальное число аргументов. В целом необязательно, но тоже можно использовать
    int maxArgs() default Integer.MAX_VALUE;

    //Показывать ли команду в списке (вовсе необязательная строка, но мало ли, пригодится!)
    boolean showInHelp() default true;

    //Какие команды будут считаться эквивалентными нашей (Например для "привет",
    // это может быть "Здаров", "Прив" и т.д., под каждый случай заводить функцию - не рационально
    String[] aliases();

}