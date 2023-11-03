package edu.hw3.Task7;

import java.util.Comparator;

public class NullComparator implements Comparator<String> {
    @Override
    public int compare(String object1, String object2) {
        if (object1 == null && object2 == null) {
            return 0;
        } else if (object1 == null) {
            return -1;
        } else if (object2 == null) {
            return 1;
        } else {
            return object1.compareTo(object2);
        }
    }
}
