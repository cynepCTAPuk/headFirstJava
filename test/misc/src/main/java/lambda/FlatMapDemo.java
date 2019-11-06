/**
 * https://vertex-academy.com/tutorials/ru/java-8-stream-flatmap/
 */
package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapDemo {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human("Sam", Arrays.asList("Buddy", "Luce")),
                new Human("Bob", Arrays.asList("Frankie", "Rosie")),
                new Human("Marta", Arrays.asList("Simba", "Tilly")));
        List<String> petNames;

        petNames = new ArrayList<>();
        for (Human human : humans) petNames.addAll(human.getPets());
        System.out.println(petNames);

        petNames = humans.stream()
                .map(human -> human.getPets())
                .flatMap(pets -> pets.stream())
                .collect(Collectors.toList());
        System.out.println(petNames);

        petNames = humans.stream()
                .flatMap(human -> human.getPets().stream())
                .collect(Collectors.toList());
        System.out.println(petNames);

        int[][] arr = {{1, 2}, {3, 4, 5}, {6, 7, 8, 9}};
        int length = 0;
        for (int[] ints : arr) length += ints.length;
        int[] arr1 = new int[length];
        for (int i = 0, idx = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr1[idx++] = arr[i][j];
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = Arrays.stream(arr).flatMapToInt(i -> Arrays.stream(i)).toArray();
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = Arrays.stream(arr).flatMapToInt(Arrays::stream).toArray();
        System.out.println(Arrays.toString(arr3));
    }
}

