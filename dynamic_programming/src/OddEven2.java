import java.util.HashMap;
import java.util.LinkedList;

public class OddEven2 {
    public static void main(String[] args) {
        int n = 100;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(n);

        LinkedList<Integer> queue = new LinkedList<>();
        //Храним индексы, для которых ещё не вычислены зависимости

        queue.add(n);
        int dum;
        while (queue.size() > 0) { //Пока есть что вычислять
            dum = queue.removeFirst();

            if (dum % 2 == 0) { //Проверяем чётность
                if (dum / 2 > 1) { //Если вычисленная зависимость не принадлежит начальным состояниям
                    stack.addLast(dum / 2); //Добавляем в стек
                    queue.add(dum / 2); //Сохраняем, чтобы вычислить дальнейшие зависимости
                }
                if (dum / 2 - 1 > 1) { //Проверяем принадлежность к начальным состояниям
                    stack.addLast(dum / 2 - 1); //Добавляем в стек
                    queue.add(dum / 2 - 1); //Сохраняем, чтобы вычислить дальнейшие зависимости
                }

            } else {
                if ((dum - 1) / 2 > 1) { //Проверяем принадлежность к начальным состояниям
                    stack.addLast((dum - 1) / 2); //Добавляем в стек
                    queue.add((dum - 1) / 2); //Сохраняем, чтобы вычислить дальнейшие зависимости
                }
                if ((dum - 1) / 2 - 1 > 1) { //Проверяем принадлежность к начальным состояниям
                    stack.addLast((dum - 1) / 2 - 1); //Добавляем в стек
                    queue.add((dum - 1) / 2 - 1); //Сохраняем, чтобы вычислить дальнейшие зависимости
                }
            }
            // Конкретно для этой задачи есть более элегантный способ найти все зависимости,
            // здесь же показан достаточно универсальный
        }

        HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();
        values.put(0, 1); //Важно добавить начальные состояния в таблицу значений
        values.put(1, 1);

        while (stack.size() > 0) {
            int num = stack.removeLast();

            if (!values.containsKey(num)) { //Эту конструкцию вы должны помнить с абзаца о кешировании
                if (num % 2 == 0) { //Проверяем чётность
                    int value = values.get(num / 2) + values.get(num / 2 - 1); //Вычисляем значение
                    values.put(num, value); //Помещаем его в таблицу
                } else {
                    int value = values.get((num - 1) / 2) - values.get((num - 1) / 2 - 1); //Вычисляем значение
                    values.put(num, value); //Помещаем его в таблицу
                }
            }
        }
    }
}
