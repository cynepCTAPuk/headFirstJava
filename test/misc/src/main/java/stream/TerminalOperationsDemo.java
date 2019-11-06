/**
 * https://habr.com/ru/company/luxoft/blog/270383/
 */
package stream;

import java.util.*;
import java.util.stream.Collectors;

public class TerminalOperationsDemo {
    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3");
        List<StringBuilder> list = new ArrayList<>();
        Set<StringBuilder> set = new TreeSet<>();
        List<Integer> integers = new ArrayList<>();

//        findFirst Возвращает первый элемент из стрима (возвращает Optional)
        collection.stream()
                .findFirst().orElse("1");
//        findAny Возвращает любой подходящий элемент из стрима(возвращает Optional)
        collection.stream()
                .findAny().orElse("1");
//        collect Представление результатов в виде коллекций и других структур данных
        collection.stream()
                .filter((s) -> s.contains("1"))
                .collect(Collectors.toList());
//        count Возвращает количество элементов в стриме
        collection.stream()
                .filter("a1"::equals)
                .count();
//        anyMatch Возвращает true, если условие выполняется хотя бы для одного элемента
        collection.stream()
                .anyMatch("a1"::equals);
//        noneMatch Возвращает true, если условие не выполняется ни для одного элемента
        collection.stream()
                .noneMatch("a8"::equals);
//        allMatch Возвращает true, если условие выполняется для всех элементов
        collection.stream()
                .allMatch((s) -> s.contains("1"));
//        min Возвращает минимальный элемент, в качестве условия использует компаратор
        collection.stream()
                .min(String::compareTo)
                .get();
//        max Возвращает максимальный элемент, в качестве условия использует компаратор
        collection.stream()
                .max(String::compareTo)
                .get();
//        forEach Применяет функцию к каждому объекту стрима, порядок при параллельном выполнении не гарантируется
        set.stream()
                .forEach((p) -> p.append("_1"));
//        forEachOrdered Применяет функцию к каждому объекту стрима, сохранение порядка элементов гарантирует
        list.stream()
                .forEachOrdered((p) -> p.append("_new"));
//        toArray Возвращает массив значений стрима
        collection.stream()
                .map(String::toUpperCase)
                .toArray(String[]::new);
//        reduce Позволяет выполнять агрегатные функции на всей коллекцией и возвращать один результат
        integers.stream()
                .reduce((s1, s2) -> s1 + s2).orElse(0);
    }
}
