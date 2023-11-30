package edu.hw7.Task3;

import java.util.List;

interface PersonDatabase {
    void add(RealPerson person);

    void delete(int id);

    List<RealPerson> findByName(String name);

    List<RealPerson> findByAddress(String address);

    List<RealPerson> findByPhone(String phone);
}

