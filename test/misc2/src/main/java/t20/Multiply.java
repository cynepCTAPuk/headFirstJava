package t20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Multiply {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(multiply(list));
        System.out.println(multiply2(list));
    }

    static List<Integer> multiply(List<Integer> list) {
        int count = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int k = 1;
            for (int j = 0; j < list.size(); j++) {
                count++;
                if (i != j) k = k * list.get(j);
            }
            result.add(k);
        }
        System.out.println(count);
        return result;
    }

    static List<Integer> multiply2(List<Integer> list) {
        int count = 0;
//        List<Integer> result = new ArrayList<>(Collections.nCopies(list.size(), 0));
        List<Integer> result = Stream.iterate(0, n -> n).limit(list.size()).collect(Collectors.toList());
        System.out.println(result);
        int start = 0;
        for (Integer i : list) {
            count++;
            if (i != 0) {
                start = 1;
                break;
            }
        }
        if (start == 0) return result;
        int multiAll = 1;
        int index = -1;
        for (int j = 0; j < list.size(); j++) {
            count++;
            Integer value = list.get(j);
            if (value == 0 && index == -1) {
                index = j;
                continue;
            }
            multiAll *= value;
        }
        if (multiAll == 0) return result;
        if (index != -1) {
            result.set(index, multiAll);
        } else {
            for (int i = 0; i < list.size(); i++) {
                count++;
                result.set(i, multiAll / list.get(i));
            }
        }
        System.out.println(count);
        return result;
    }
}
