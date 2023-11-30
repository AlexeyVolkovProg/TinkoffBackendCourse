package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * В задачах кэширования часто есть дисбаланс между количеством чтений и записи.
 * Добавьте решение для предыдущей задачи на основе ReadWriteLock.
 */
public class DatabaseLock implements PersonDatabase {
    public DatabaseLock() {

    }

    private final Map<Integer, RealPerson> idIndex = new HashMap<>();
    private final Map<String, List<RealPerson>> nameIndex = new HashMap<>();
    private final Map<String, List<RealPerson>> addressIndex = new HashMap<>();
    private final Map<String, List<RealPerson>> phoneIndex = new HashMap<>();

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    @Override
    public void add(RealPerson person) {
        readWriteLock.writeLock();
        try {
            if (person.attributesNotNull()) {
                idIndex.put(person.id(), person);
                addToIndex(nameIndex, person.name(), person);
                addToIndex(addressIndex, person.address(), person);
                addToIndex(phoneIndex, person.phoneNumber(), person);
            }
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        readWriteLock.writeLock();
        try {
            RealPerson personToRemove = idIndex.remove(id);
            removeFromIndex(nameIndex, personToRemove.name(), personToRemove);
            removeFromIndex(addressIndex, personToRemove.address(), personToRemove);
            removeFromIndex(phoneIndex, personToRemove.phoneNumber(), personToRemove);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public List<RealPerson> findByName(String name) {
        readWriteLock.readLock();
        try {
            return nameIndex.getOrDefault(name, new ArrayList<>());
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public List<RealPerson> findByAddress(String address) {
        readWriteLock.readLock();
        try {
            return addressIndex.getOrDefault(address, new ArrayList<>());
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public List<RealPerson> findByPhone(String phone) {
        readWriteLock.readLock();
        try {
            return phoneIndex.getOrDefault(phone, new ArrayList<>());
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    /**
     * Осуществляем запись в Index БД
     */
    private void addToIndex(Map<String, List<RealPerson>> index, String key, RealPerson person) {
        readWriteLock.writeLock();
        try {
            index.computeIfAbsent(key, k -> new ArrayList<>()).add(person);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    /**
     * Осуществляем удаление
     */
    private void removeFromIndex(Map<String, List<RealPerson>> index, String key, RealPerson person) {
        readWriteLock.writeLock();
        try {
            List<RealPerson> people = index.get(key);
            if (people != null) {
                people.remove(person);
                if (people.isEmpty()) {
                    index.remove(key);
                }
            }
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

}
