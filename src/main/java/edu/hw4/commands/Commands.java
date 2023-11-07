package edu.hw4.commands;

import edu.hw4.data.Animal;
import edu.hw4.data.AnimalValidator;
import edu.hw4.data.ValidatorError;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Commands {

    private Commands() {

    }

    private static final int MIN_HEIGHT_TASK_8 = 100;

    /**
     * Отсортировать животных по росту от самого маленького к самому большому -> List Animal
     */
    public static List<Animal> task1(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }

    /**
     * Отсортировать животных по весу от самого тяжелого к самому легкому, выбрать k первых -> List Animal
     */
    public static List<Animal> task2(List<Animal> animals, int counter) {
        int k = counter;
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .collect(Collectors.toList());
    }

    /**
     * Сколько животных каждого вида -> Map (Animal.Type, Integer)
     */
    public static Map<Animal.Type, Long> task3(List<Animal> animals) {
        return animals.stream().collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
    }

    /**
     * У какого животного самое длинное имя -> Animal
     */
    public static Animal task4(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(a -> a.name().length()))
            .orElse(null);
    }

    /**
     * Каких животных больше: самцов или самок -> Sex
     */

    public static Animal.Sex task5(List<Animal> animals) {
        long maleCounter = animals.stream()
            .filter(a -> a.sex() == Animal.Sex.M)
            .count();
        long femaleCounter = animals.size() - maleCounter;
        return (maleCounter >= femaleCounter) ? Animal.Sex.M : Animal.Sex.F;
    }

    /**
     * Самое тяжелое животное каждого вида -> Map(Animal.Type, Animal)
     */
    public static Map<Animal.Type, Animal> task6(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(Animal::type, Function.identity(),
                BinaryOperator.maxBy(Comparator.comparingInt(Animal::weight))
            ));
    }

    /**
     * K-е самое старое животное -> Animal
     */
    public static Animal task7(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed()) // пересмотреть
            .skip(k - 1)
            .findFirst()
            .orElse(null);
    }

    /**
     * Самое тяжелое животное среди животных ниже k см -> Optional(Animal)
     */
    public static Optional<Animal> task8(List<Animal> animals, int k) {
        return animals.stream()
            .filter(a -> a.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    /**
     * Сколько в сумме лап у животных в списке -> Integer
     */

    public static Integer task9(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    /**
     * Список животных, возраст у которых не совпадает с количеством лап -> List(Animal)
     */
    public static List<Animal> task10(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.age() != a.paws())
            .collect(Collectors.toList());
    }

    /**
     * Список животных, которые могут укусить (bites == true) и рост которых превышает 100 см -> List(Animal)
     */

    public static List<Animal> task11(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.bites() && a.height() > MIN_HEIGHT_TASK_8)
            .collect(Collectors.toList());
    }

    /**
     * Сколько в списке животных, вес которых превышает рост -> Integer
     */

    public static Long task12(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.weight() > a.height())
            .count();
    }

    /**
     * Список животных, имена которых состоят из более чем двух слов -> List(Animal)
     */
    public static List<Animal> task13(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.name().split(" ").length > 1)
            .collect(Collectors.toList());
    }

    /**
     * Есть ли в списке собака ростом более k см -> Boolean
     */
    public static Boolean task14(List<Animal> animals, int k) {
        return animals.stream().anyMatch(a -> a.type() == Animal.Type.DOG && a.height() > k);
    }

    /**
     * Найти суммарный вес животных каждого вида, которым от k до l лет -> Map(AnimalType, Integer)
     */

    public static Map<Animal.Type, Integer> task15(List<Animal> animals, int k, int l) {
        return animals.stream()
            .filter(a -> a.age() >= k && a.age() <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    /**
     * Список животных, отсортированный по виду, затем по полу, затем по имени -> List(Animal)
     */
    public static List<Animal> task16(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator
                .comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .collect(Collectors.toList());
    }

    /**
     * Правда ли, что пауки кусаются чаще, чем собаки -> Boolean (если данных для ответа недостаточно, вернуть false)
     */
    public static Boolean task17(List<Animal> animals) {
        long spiderBites = animals.stream()
            .filter(a -> a.type() == Animal.Type.SPIDER && a.bites())
            .count();
        long dogBites = animals.stream()
            .filter(a -> a.type() == Animal.Type.DOG && a.bites())
            .count();
        return spiderBites > dogBites;
    }

    /**
     * Найти самую тяжелую рыбку в 2-х или более списках -> Animal
     */
    public static Animal task18(List<List<Animal>> listOfAnimalLists) {
        return listOfAnimalLists.stream()
            .flatMap(List::stream)
            .filter(a -> a.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }

    /**
     * Животные, в записях о которых есть ошибки: вернуть имя и список ошибок -> Map(String, Set(ValidationError)).
     * Класс ValidationError и набор потенциальных проверок нужно придумать самостоятельно.
     */

    public static Map<String, Set<ValidatorError>> task19(List<Animal> animals) {
        Map<String, Set<ValidatorError>> errorsMap = new HashMap<>();

        for (Animal animal : animals) {
            Set<ValidatorError> errors = AnimalValidator.validateAnimal(animal);
            if (!errors.isEmpty()) {
                errorsMap.put(animal.name(), errors);
            }
        }
        return errorsMap;
    }

    /**
     * Сделать результат предыдущего задания более читабельным:
     * вернуть имя и названия полей с ошибками, объединенные в строку -> Map(String, String)
     */

    public static Map<String, String> task20(List<Animal> animals) {
        Map<String, Set<ValidatorError>> errorsMap = task19(animals);
        Map<String, String> readableErrors = new HashMap<>();

        for (Map.Entry<String, Set<ValidatorError>> entry : errorsMap.entrySet()) {
            String name = entry.getKey();
            Set<ValidatorError> errors = entry.getValue();

            StringBuilder errorStringBuilder = new StringBuilder();
            for (ValidatorError error : errors) {
                errorStringBuilder.append(error).append("; ");
            }

            String combinedErrors = errorStringBuilder.toString().trim();
            readableErrors.put(name, combinedErrors);
        }

        return readableErrors;
    }

}
