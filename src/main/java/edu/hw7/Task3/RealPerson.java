package edu.hw7.Task3;

public record RealPerson(int id, String name, String address, String phoneNumber) {
    public Boolean attributesNotNull() {
        return name != null && address != null && phoneNumber != null;
    }
}

