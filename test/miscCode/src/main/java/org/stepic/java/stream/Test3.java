package org.stepic.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * assert предикат: сообщение;
 * Предикат – выражение с типом boolean. Если выражение является ложным, то в программе
 * возникает исключение AssertionError с соответствующим сообщением.
 * Чтобы ее включить, необходимо передать специальный ключ -ea в параметры виртуальной машины.
 * Сделать это можно прямо при запуске в консоли с помощью программы java, либо указав этот ключ
 * в настройках запуска программы в вашей IDE. В случае IntellijIDEA, например,
 * эта опция указывается в поле Run -> Edit Configurations... -> конфигурация запуска вашей
 * программы -> VM Options.
 */
public class Test3 {
    public static void main(String[] args) {
        // Random variables
        String randomFrom = "me"; // Некоторая случайная строка
        String randomTo = "you";  // Некоторая случайная строка
        int randomSalary = 100;  // Некоторое случайное целое положительное число.

        // Создание списка из трех почтовых сообщений.
        MailMessage firstMessage = new MailMessage("Robert Howard", "H.P. Lovecraft", "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!");
        assert firstMessage.getFrom().equals("Robert Howard") : "Wrong firstMessage from address";
        assert firstMessage.getTo().equals("H.P. Lovecraft") : "Wrong firstMessage to address";
        assert firstMessage.getContent().endsWith("Howard!") : "Wrong firstMessage content ending";
        MailMessage secondMessage = new MailMessage("Jonathan Nolan", "Christopher Nolan", "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!");
        MailMessage thirdMessage = new MailMessage("Stephen Hawking", "Christopher Nolan", "Я так и не понял Интерстеллар.");
        List<MailMessage> messages = Arrays.asList(firstMessage, secondMessage, thirdMessage);
        // Создание почтового сервиса.
        MailService<String> mailService = new MailService();
        // Обработка списка писем почтовым сервисом
        messages.stream().forEachOrdered(mailService);
        System.out.println(messages);
        // Получение и проверка словаря "почтового ящика",
        // где по получателю можно получить список сообщений, которые были ему отправлены
        Map<String, List<String>> mailBox = mailService.getMailBox();
        System.out.println(mailBox);
        assert mailBox.get("H.P. Lovecraft").equals(Arrays.asList("This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!")) : "wrong mailService mailbox content (1)";
        assert mailBox.get("Christopher Nolan").equals(Arrays.asList("Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!", "Я так и не понял Интерстеллар.")) : "wrong mailService mailbox content (2)";
        assert mailBox.get(randomTo).equals(Collections.<String>emptyList()) : "wrong mailService mailbox content (3)";

        // Создание списка из трех зарплат.
        Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
        Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);
        // Создание почтового сервиса, обрабатывающего зарплаты.
        MailService<Integer> salaryService = new MailService<>();
        // Обработка списка зарплат почтовым сервисом
        Arrays.asList(salary1, salary2, salary3).forEach(salaryService);
        // Получение и проверка словаря "почтового ящика",
        // где по получателю можно получить список зарплат, которые были ему отправлены.
        Map<String, List<Integer>> salaries = salaryService.getMailBox();
        System.out.println(salaries);
        assert salaries.get(salary1.getTo()).equals(Arrays.asList(1)) : "wrong salaries mailbox content (1)";
        assert salaries.get(salary2.getTo()).equals(Arrays.asList(Integer.MAX_VALUE)) : "wrong salaries mailbox content (2)";
        assert salaries.get(randomTo).equals(Arrays.asList(randomSalary)) : "wrong salaries mailbox content (3)";

    }

    public static class MailService<T> implements Consumer<Sendable<T>> {
        private final Map<String, List<T>> map = new HashMap<>() {
            @Override
            public List<T> get(Object key) {
                return this.containsKey(key) ? super.get(key) : Collections.emptyList();
//                return super.getOrDefault(key, Collections.emptyList());
            }
        };

        public Map<String, List<T>> getMailBox() {
            return map;
        }

        @Override
        public void accept(Sendable<T> sendable) {
/*
            String to = sendable.getTo();
            if (!map.containsKey(to)) map.put(to, new ArrayList<>());
            map.get(to).add(sendable.getContent());
*/

            List<T> list = map.get(sendable.getTo());
            if (list.size() == 0) list = new ArrayList<>();
            list.add(sendable.getContent());
            map.put(sendable.getTo(), list);
        }
    }

    public static class MailMessage extends SimpleSendable<String> {
        public MailMessage(String from, String to, String content) {
            super(from, to, content);
        }
    }

    public static class Salary extends SimpleSendable<Integer> {
        public Salary(String from, String to, Integer content) {
            super(from, to, content);
        }
    }

    public interface Sendable<T> {
        String getFrom();

        String getTo();

        T getContent();
    }

    public static class SimpleSendable<T> implements Sendable<T> {
        private final String from;
        private final String to;
        private final T content;

        public SimpleSendable(String from, String to, T content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public T getContent() {
            return content;
        }
    }
}
