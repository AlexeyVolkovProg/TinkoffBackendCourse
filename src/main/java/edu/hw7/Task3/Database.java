package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Мы пишем специальный кэширующий сервис для поиска людей по атрибутам:
 * Сервис должен позволять найти человека только тогда, когда он стал доступен для поиска по любому из атрибутов,
 * то есть невозможна ситуация, когда человека с id=3 можно найти по имени, но нельзя по телефону.
 * Другими словами, человек появляется в поиске только тогда, тогда он доступен к поиску везде.
 * Не может быть такого, что FindByX вернул что-то, а FindByY -- ничего.
 * Реализуйте задачу при помощи synchronized.
 * В общем случае можно воспринимать эту задачу
 * как разработку некоторой in-memory базы ключ-значение с наличием обратных индексов.
 */
public class Database implements PersonDatabase {
    public Database() {

    }

    private final Map<Integer, RealPerson> idIndex = new HashMap<>();
    private final Map<String, List<RealPerson>> nameIndex = new HashMap<>();
    private final Map<String, List<RealPerson>> addressIndex = new HashMap<>();
    private final Map<String, List<RealPerson>> phoneIndex = new HashMap<>();

    @Override
    public synchronized void add(RealPerson person) {
        if (person.attributesNotNull()) {
            idIndex.put(person.id(), person);
            addToIndex(nameIndex, person.name(), person);
            addToIndex(addressIndex, person.address(), person);
            addToIndex(phoneIndex, person.phoneNumber(), person);
        }
    }

    @Override
    public synchronized void delete(int id) {
        RealPerson personToRemove = idIndex.remove(id);
        removeFromIndex(nameIndex, personToRemove.name(), personToRemove);
        removeFromIndex(addressIndex, personToRemove.address(), personToRemove);
        removeFromIndex(phoneIndex, personToRemove.phoneNumber(), personToRemove);
    }

    @Override
    public synchronized List<RealPerson> findByName(String name) {
        return nameIndex.getOrDefault(name, new ArrayList<>());
    }

    @Override
    public synchronized List<RealPerson> findByAddress(String address) {
        return addressIndex.getOrDefault(address, new ArrayList<>());
    }

    @Override
    public synchronized List<RealPerson> findByPhone(String phone) {
        return phoneIndex.getOrDefault(phone, new ArrayList<>());
    }

    /**
     * Осуществляем запись в Index БД
     */
    private void addToIndex(Map<String, List<RealPerson>> index, String key, RealPerson person) {
        index.computeIfAbsent(key, k -> new ArrayList<>()).add(person);
    }

    /**
     * Осуществляем удаление
     */
    private void removeFromIndex(Map<String, List<RealPerson>> index, String key, RealPerson person) {
        List<RealPerson> people = index.get(key);
        if (people != null) {
            people.remove(person);
            if (people.isEmpty()) {
                index.remove(key);
            }
        }
    }
}
