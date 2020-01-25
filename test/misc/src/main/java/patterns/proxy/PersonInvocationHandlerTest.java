package patterns.proxy;

import java.lang.reflect.Proxy;

/**
 * https://javarush.ru/groups/posts/2281-dinamicheskie-proksi
 */
public class PersonInvocationHandlerTest {
    public static void main(String[] args) {
        //Создаем оригинальный объект
        Man vasia = new Man("Вася", 30, "Санкт-Петербург", "Россия");

        //Получаем загрузчик класса у оригинального объекта
        ClassLoader classLoader = vasia.getClass().getClassLoader();

        //Получаем все интерфейсы, которые реализует оригинальный объект
        Class[] interfaces = vasia.getClass().getInterfaces();

        //Создаем прокси нашего объекта vasia
        PersonInvocationHandler invocationHandler = new PersonInvocationHandler(vasia);
        Person person = (Person) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        //Вызываем у прокси объекта один из методов нашего оригинального объекта
        person.introduce(vasia.getName());
    }
}
