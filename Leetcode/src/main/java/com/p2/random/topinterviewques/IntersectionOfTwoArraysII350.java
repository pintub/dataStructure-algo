package com.p2.random.topinterviewques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numVsCount = new HashMap<>();
        for(int num : nums1) {
            Integer count = numVsCount.getOrDefault(num, 0);
            numVsCount.put(num, ++count);
        }

        List<Integer> result = new ArrayList<>();
        for(int num : nums2) {
            Integer count = numVsCount.get(num);
            if(count != null && count > 0) {
                result.add(num);
                numVsCount.put(num, --count);
            }
        }

        int[] arr = new int[result.size()];
        int count = 0;
        for (Integer i : result) {
            arr[count++] = i;
        }
        return arr;
    }
}
