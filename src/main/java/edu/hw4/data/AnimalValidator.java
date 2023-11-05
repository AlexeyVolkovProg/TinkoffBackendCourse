package edu.hw4.data;

import java.util.HashSet;
import java.util.Set;

public class AnimalValidator {
    private AnimalValidator() {

    }

    public static Set<ValidatorError> validateAnimal(Animal animal) {
        Set<ValidatorError> errors = new HashSet<>();

        if (animal.age() < 0) {
            errors.add(new ValidatorError("Возраст", "Возраст не может быть отрицательным числом"));
        }

        if (animal.height() < 0) {
            errors.add(new ValidatorError("Высота", "Высота не может быть отрицательным числом"));
        }

        if (animal.weight() < 0) {
            errors.add(new ValidatorError("Вес", "Вес не может быть отрицательным числом"));
        }

        return errors;
    }
}
