package stream.saAlexKorolev;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static List<Animal> getAnimals() {
        return List.of(
                new Animal("Слон", 20, Classification.HERBIVORE),
                new Animal("Лев", 10, Classification.PREDATOR),
                new Animal("Гиена", 11, Classification.PREDATOR),
                new Animal("Жираф", 7, Classification.HERBIVORE),
                new Animal("Гибон", 35, Classification.OMNIVOROUS),
                new Animal("Лошадь", 36, Classification.HERBIVORE),
                new Animal("Рысь", 2, Classification.PREDATOR),
                new Animal("Динозавр", 200, Classification.PREDATOR)
        );
    }

    public static void main(String[] args) {
        List<Animal> animals = getAnimals();
        List<Animal> predators = new ArrayList<>();
        // old approach
//        for (Animal animal : animals)
//            if (animal.getClassification().equals(Classification.PREDATOR)) predators.add(animal);
//        predators.forEach(System.out::println);

        // Filter
        predators = animals.stream()
                .filter(animal -> animal.getClassification().equals(Classification.PREDATOR))
                .collect(Collectors.toList());
//        predators.forEach(System.out::println);
        // Sort
//        animals.forEach(System.out::println);
        List<Animal> sorted = animals.stream()
                .sorted(Comparator.comparing(Animal::getAge)
                        .thenComparing(Animal::getClassification)
                        .reversed()
                )
//                .sorted(Comparator.comparing(Animal::getClassification))
                .collect(Collectors.toList());
//        sorted.forEach(System.out::println);
        // All match
        boolean allMatch = animals.stream()
                .allMatch(animal -> animal.getAge() > 10);
//        System.out.println(allMatch);
        // Any match
        boolean anyMatch = animals.stream()
                .anyMatch(animal -> animal.getAge() > 10);
//        System.out.println(anyMatch);
        // None match
        boolean noneMatch = animals.stream()
                .noneMatch(animal -> animal.getName().equals("Медведь"));
//        System.out.println(noneMatch);
        // Max
        animals.stream()
                .max(Comparator.comparing(Animal::getAge))
                .ifPresent(System.out::println);
        // Min
        animals.stream()
                .min(Comparator.comparing(Animal::getAge))
                .ifPresent(System.out::println);
        // Group
        Map<Classification, List<Animal>> classificationListMap = animals.stream()
                .collect(Collectors.groupingBy(Animal::getClassification));
        classificationListMap.forEach((classification, animalsGroupBy) -> {
            System.out.println(classification);
            animalsGroupBy.forEach(System.out::println);
        });

        Optional<String> oldestPredatorAge = animals.stream()
                .filter(animal -> animal.getClassification().equals(Classification.PREDATOR))
                .max(Comparator.comparing(Animal::getAge))
                .map(Animal::getName);
        oldestPredatorAge.ifPresent(System.out::println);
    }
}
