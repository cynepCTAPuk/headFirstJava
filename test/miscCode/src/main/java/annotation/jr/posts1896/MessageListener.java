package annotation.jr.posts1896;
/**
 * https://javarush.ru/groups/posts/1896-java-annotacii-chto-ehto-i-kak-ehtim-poljhzovatjhsja
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MessageListener {
    //Map который хранит как ключ команду ("привет"),
    // а как значение функцию которая будет обрабатывать команду
    private static final CommandListener listener = new CommandListener();
    //Объект класса с командами (по сути нужен нам для рефлекции)
    private static final Map<String, Method> commands = new HashMap<>();

    static {
        //Берем список всех методов в классе CommandListener
        for (Method m : listener.getClass().getDeclaredMethods()) {
            //Смотрим, есть ли у метода нужная нам Аннотация @Command
            if (m.isAnnotationPresent(Command.class)) {
                //Берем объект нашей Аннотации
                Command cmd = m.getAnnotation(Command.class);
                //Обращаемся к аргументу name (чтобы использовать его как ключ),
                // m - переменная хранящая наш метод
                commands.put(cmd.name(), m);
                //Также заносим каждый элемент aliases как ключ указывающий на тот же самый метод.
                for (String s : cmd.aliases()) commands.put(s, m);
            }
        }
    }

    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().toLowerCase();
        if (message.startsWith("бот")) {
            try {
                String[] args = message.split(" ");
                String command = args[1].toLowerCase();
                String[] nArgs = Arrays.copyOfRange(args, 2, args.length);
                Method m = commands.get(command);
                if (m == null) return;                    //(вывод помощи)
                Command com = m.getAnnotation(Command.class);
                if (nArgs.length < com.minArgs()) {
                    //что-то если аргументов меньше чем нужно
                } else if (nArgs.length > com.maxArgs()) {
                    //что-то если аргументов больше чем нужно
                }
                //Через рефлекцию вызываем нашу функцию-обработчик (именно потому что мы всегда
                // передаем nArgs у функции должен быть параметр String[] args - иначе
                // она просто не будет найдена);
                m.invoke(listener, nArgs);
            } catch (ArrayIndexOutOfBoundsException e) {
                //Вывод списка команд или какого-либо сообщения, в случае если просто написать "Бот"
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}