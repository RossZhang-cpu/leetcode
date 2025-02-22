package com.code.string;

import java.util.List;
import java.util.Map;

public class RandomizedSet {

    private Integer[] set1;
    private Integer[] set2;

    private List<Long> valueList;
    public RandomizedSet() {
        set1 = new Integer[Integer.MAX_VALUE];
        set2 = new Integer[Integer.MAX_VALUE];

    }

    public boolean insert(int val) {
        Map.Entry<Integer, Integer[]> entry;
        entry = findEntry(val);

        Integer[] set = entry.getValue();
        boolean flag = false;
        if (set[entry.getKey()] == null) {
            set[entry.getKey()] = val;
            flag = true;
        }
        return flag;
    }

    private Map.Entry<Integer, Integer[]> findEntry(int val) {
        if (val >= 0) {
            int index = val;
            return Map.entry(index, set1);
        } else {
            int index = Math.abs(val + 1);
            return Map.entry(index, set2);
        }
    }

    public boolean remove(int val) {
        Map.Entry<Integer, Integer[]> entry = findEntry(val);
        Integer[] set = entry.getValue();
        boolean flag = false;
        if (set[entry.getKey()] != null) {
            set[entry.getKey()] = null;
            flag = true;
        }

        return flag;
    }

}
