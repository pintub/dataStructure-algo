package com.p2.random.topinterviewques;

import java.util.Arrays;

/**
 * 1st Sort
 * 4,5,5,6, copy to Extra space
 *
 * output array
 *      index 1,3,5...
 *      6,5.... //Sorted Array reverse order
 *
 *      index 0,2,4
 *      5,4.... //Sorted Array reverse order
 *
 *  Output Array:
 *        5  6 4  5
 */
public class WiggleSortII324 {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] numsCopy = Arrays.copyOf(nums, nums.length);

        int sortedArrayIndex = nums.length - 1;
        for (int idx = 0; idx < nums.length; idx += 2) {
            nums[idx] = numsCopy[sortedArrayIndex--];
        }

        for (int idx = 1; idx < nums.length; idx += 2) {
            nums[idx] = numsCopy[sortedArrayIndex--];
        }
    }

    public static void main(String[] args) {
        WiggleSortII324 sol = new WiggleSortII324();
        //int[] arr = new int[]{1, 3, 2, 2, 3, 1};
        int[] arr = new int[]{1,5,1,1,6,4};
        sol.wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
