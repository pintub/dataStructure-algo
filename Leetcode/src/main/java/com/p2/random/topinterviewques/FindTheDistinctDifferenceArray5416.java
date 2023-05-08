package com.p2.random.topinterviewques;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheDistinctDifferenceArray5416 {

    public int[] distinctDifferenceArray(int[] nums) {
        Set<Integer> prefix = new HashSet<>();
        Map<Integer, Integer> suffix = new HashMap<>();
        for(int num : nums) {
            Integer count = suffix.getOrDefault(num, 0);
            suffix.put(num, count + 1);
        }

        for(int index = 0; index < nums.length; index++) {
            int currentNum = nums[index];
            prefix.add(currentNum);
            Integer currentNumCount = suffix.get(currentNum);
            if(currentNumCount == 1) {
                suffix.remove(currentNum);
            } else {
                suffix.put(currentNum, currentNumCount - 1);
            }

            nums[index] = prefix.size() - suffix.size();
        }

        return nums;
    }

    public static void main(String[] args) {
        FindTheDistinctDifferenceArray5416 sol = new FindTheDistinctDifferenceArray5416();
        System.out.println(Arrays.toString(sol.distinctDifferenceArray(new int[]{1,2,3,4,5})));
    }
}
