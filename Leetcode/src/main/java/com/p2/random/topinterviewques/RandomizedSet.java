package com.p2.random.topinterviewques;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {

    Map<Integer, Integer> randomizedSet;
    List<Integer> list;

    public RandomizedSet() {
        randomizedSet = new HashMap<>();
        list = new ArrayList<>();
    }

    void insertAtEndOfList(int val) {
        list.add(val);
    }

    void deleteValueAtIndexFromList(int index) {
        if(list.size() == 1) {//Only 1 element
            list.remove(0);
            return;
        }

        int listSize = list.size();
        if(list.size()-1 == index) {//Last elemnt to be deleted
            list.remove(listSize - 1);
            return;
        }

        int lastElement = list.get(listSize - 1);
        list.remove(listSize - 1);
        list.set(index, lastElement);
        randomizedSet.put(list.get(index), index);   //Side Effect Code
    }

    public boolean insert(int val) {
        boolean ableToInsert = false;
        if(randomizedSet.get(val) == null) {//Not exists
            ableToInsert = true;
            randomizedSet.put(val, list.size());
            insertAtEndOfList(val);
        }
        return ableToInsert;
    }

    public boolean remove(int val) {
        boolean isExist = false;
        if(randomizedSet.get(val) != null) {//exists
            isExist = true;
            int index = randomizedSet.get(val);
            randomizedSet.remove(val);
            deleteValueAtIndexFromList(index);
        }
        return isExist;
    }

    public int getRandom() {
        int randomIndex = (int)(Math.random() * list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.insert(10); // Returns false as 2 does not exist in the set.
        randomizedSet.insert(20); // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomizedSet.insert(30); // Removes 1 from the set, returns true. Set now contains [2].
        randomizedSet.getRandom();
        randomizedSet.getRandom();

        randomizedSet.getRandom();

        randomizedSet.getRandom();

        randomizedSet.getRandom();

    }
}
