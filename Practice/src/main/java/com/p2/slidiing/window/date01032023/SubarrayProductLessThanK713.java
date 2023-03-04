package com.p2.slidiing.window.date01032023;

public class SubarrayProductLessThanK713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;

        //Memo
        int product = 1;
        //Result
        int result = 0;


        while (right < nums.length) {
            product *= nums[right];

            boolean isValidWindow = product < k;
            if(isValidWindow) {
                result += right - left + 1;
                ++right;
            } else {//Shift left & make it valid
                while (product >= k && left <= right) {
                    product = product / nums[left];
                    ++left;
                }
                result += right - left + 1;
                ++right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK713 sol = new SubarrayProductLessThanK713();
        //System.out.println(sol.numSubarrayProductLessThanK(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
        System.out.println(sol.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 1) == 0);
        System.out.println(sol.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100) == 8);
        System.out.println(sol.numSubarrayProductLessThanK(new int[]{1,2,3}, 0) == 0);
    }
}
