package edu.hw4;

import edu.hw4.commands.Commands;
import edu.hw4.data.Animal;
import edu.hw4.data.ValidatorError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCommands {
    private List<Animal> animals;

    @BeforeEach
    void setUp() {
        animals = new ArrayList<>();
        animals.add(new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, false));
        animals.add(new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 4, 40, 8, true));
        animals.add(new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 2, 10, 1, true));
        animals.add(new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 1, 8, 2, true));
        animals.add(new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 1, 2, 0, true));
        animals.add(new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.F, 2, 15, 2, false));
    }

    @Test
    void testTask1() {
        List<Animal> sortedAnimals = Commands.task1(animals);
        for (int i = 1; i < sortedAnimals.size(); i++) {
            assertTrue(sortedAnimals.get(i - 1).height() <= sortedAnimals.get(i).height());
        }
    }

    @Test
    void testTask2() {
        List<Animal> heaviestAnimals = Commands.task2(animals, 2);
        assertEquals(2, heaviestAnimals.size());
        for (int i = 1; i < heaviestAnimals.size(); i++) {
            assertTrue(heaviestAnimals.get(i - 1).weight() >= heaviestAnimals.get(i).weight());
        }
    }

    @Test
    void testTask3() {
        Map<Animal.Type, Long> animalCountByType = Commands.task3(animals);
        assertEquals(1, animalCountByType.get(Animal.Type.CAT));
        assertEquals(1, animalCountByType.get(Animal.Type.DOG));
        assertEquals(2, animalCountByType.get(Animal.Type.FISH));
        assertEquals(1, animalCountByType.get(Animal.Type.SPIDER));
        assertEquals(1, animalCountByType.get(Animal.Type.BIRD));
    }

    @Test
    void testTask4() {
        Animal animalWithLongestName = Commands.task4(animals);
        assertEquals("Spider1", animalWithLongestName.name());
    }

    @Test
    void testTask5() {
        Animal.Sex dominantSex = Commands.task5(animals);
        assertEquals(Animal.Sex.M, dominantSex);
    }

    @Test
    void testTask6() {
        Map<Animal.Type, Animal> heaviestAnimalByType = Commands.task6(animals);
        assertEquals(8, heaviestAnimalByType.get(Animal.Type.DOG).weight());
        assertEquals(2, heaviestAnimalByType.get(Animal.Type.BIRD).weight());
        assertEquals(0, heaviestAnimalByType.get(Animal.Type.SPIDER).weight());
    }

    @Test
    void testTask7() {
        Animal oldestAnimal = Commands.task7(animals, 2);
        assertEquals("Cat1", oldestAnimal.name());
    }

    @Test
    void testTask8() {
        Optional<Animal> heaviestShortAnimal = Commands.task8(animals, 20);
        assertTrue(heaviestShortAnimal.isPresent());
        assertEquals("Fish2", heaviestShortAnimal.get().name());

        Optional<Animal> heaviestTallAnimal = Commands.task8(animals, 0);
        assertFalse(heaviestTallAnimal.isPresent());
    }

    @Test
    void testTask9() {
        int totalPaws = Commands.task9(animals);
        assertEquals(18, totalPaws);
    }

    @Test
    void testTask10() {
        List<Animal> mismatchedAgeAndPaws = Commands.task10(animals);
        assertEquals(4, mismatchedAgeAndPaws.size());
        assertEquals("Cat1", mismatchedAgeAndPaws.get(0).name());
    }

    @Test
    void testTask11() {
        List<Animal> potentialBiters = Commands.task11(animals);
        assertEquals(0, potentialBiters.size());
    }

    @Test
    void testTask12() {
        long count = Commands.task12(animals);
        assertEquals(0, count);
    }

    @Test
    void testTask13() {
        List<Animal> multiWordNames = Commands.task13(animals);
        assertEquals(0, multiWordNames.size());
    }

    @Test
    void testTask14() {
        assertTrue(Commands.task14(animals, 35));
        assertFalse(Commands.task14(animals, 41));
    }

    @Test
    void testTask15() {
        Map<Animal.Type, Integer> totalWeightByType = Commands.task15(animals, 1, 3);
        assertEquals(5, totalWeightByType.get(Animal.Type.CAT));
        assertEquals(null, totalWeightByType.get(Animal.Type.DOG));
        assertEquals(3, totalWeightByType.get(Animal.Type.FISH));
        assertEquals(0, totalWeightByType.get(Animal.Type.SPIDER));
        assertEquals(2, totalWeightByType.get(Animal.Type.BIRD));
    }

    @Test
    void testTask16() {
        List<Animal> sortedAnimals = Commands.task16(animals);
        List<String> names = sortedAnimals.stream().map(Animal::name).collect(Collectors.toList());
        List<String> expectedOrder = Arrays.asList("Cat1", "Dog1", "Bird1", "Fish1", "Fish2", "Spider1");
        assertEquals(expectedOrder, names);
    }

    @Test
    void testTask17() {
        assertFalse(Commands.task17(animals));
    }

    @Test
    void testTask18() {
        List<Animal> list1 = new ArrayList<>();
        list1.add(new Animal("Fish3", Animal.Type.FISH, Animal.Sex.M, 3, 15, 3, true));
        List<Animal> list2 = new ArrayList<>();
        list2.add(new Animal("Fish4", Animal.Type.FISH, Animal.Sex.F, 2, 12, 2, true));
        List<List<Animal>>listOfAnimalLists = new ArrayList<>();
        listOfAnimalLists.add(list1);
        listOfAnimalLists.add(list2);

        Animal heaviestFish = Commands.task18(listOfAnimalLists);
        assertEquals("Fish3", heaviestFish.name());
    }

    @Test
    void testTask19() {
        List<Animal> animals = List.of(
            new Animal("ValidCat", Animal.Type.CAT, Animal.Sex.M, 3, 30, 5, false),
            new Animal("InvalidCat", Animal.Type.CAT, Animal.Sex.F, -1, 20, 3, false),
            new Animal("ValidDog", Animal.Type.DOG, Animal.Sex.M, 4, 40, 8, true),
            new Animal("InvalidDog", Animal.Type.DOG, Animal.Sex.F, 5, -2, 6, true)
        );

        Map<String, Set<ValidatorError>> errors = Commands.task19(animals);

        assertTrue(errors.containsKey("InvalidCat"));
        assertTrue(errors.containsKey("InvalidDog"));
        assertFalse(errors.containsKey("ValidCat"));
        assertFalse(errors.containsKey("ValidDog"));

        Set<ValidatorError> invalidCatErrors = errors.get("InvalidCat");
        Set<ValidatorError> invalidDogErrors = errors.get("InvalidDog");

        assertEquals(1, invalidCatErrors.size());
        assertEquals(1, invalidDogErrors.size());
    }

    @Test
    void testTask20() {
        Map<String, String> readableErrors = Commands.task20(animals);
        assertTrue(readableErrors.isEmpty());

        Animal invalidAnimal = new Animal("Invalid", Animal.Type.CAT, Animal.Sex.M, -1, 30, -5, true);
        animals.add(invalidAnimal);
        readableErrors = Commands.task20(animals);

        assertTrue(readableErrors.containsKey("Invalid"));
        String errors = readableErrors.get("Invalid");
        assertTrue(errors.contains("Возраст: Возраст не может быть отрицательным числом"));
        assertTrue(errors.contains("Вес: Вес не может быть отрицательным числом"));
    }
}
