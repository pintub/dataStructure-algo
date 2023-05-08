package com.p2.random.topinterviewques;

import java.util.Arrays;

public class MissingNumber268 {

    public int missingNumber_cyclicSort(int[] nums) {
        inlineCyclicSort(nums);
        for(int idx = 0; idx < nums.length; idx++) {
            if(idx != nums[idx])
                return idx;
        }

        return nums.length;
    }

    private void inlineCyclicSort(int[] nums) {
        int idx = 0;
        while (idx < nums.length) {
            if(nums[idx] < nums.length && idx != nums[idx]) {//This is Tricky. If index not present for current element, skip
                swap(nums, idx, nums[idx]);
            } else {
                idx++;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public int missingNumber(int[] nums) {
        int len = nums.length;
        return (len * (len + 1) / 2) - Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        MissingNumber268 sol = new MissingNumber268();
        System.out.println(sol.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

}
