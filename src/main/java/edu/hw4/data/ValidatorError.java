package edu.hw4.data;

public class ValidatorError {
    private String field;
    private String message;

    public ValidatorError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return field + ": " + message;
    }
}

