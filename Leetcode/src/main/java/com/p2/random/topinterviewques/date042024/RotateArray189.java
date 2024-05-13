package com.p2.random.topinterviewques.date042024;

import java.util.Arrays;

public class RotateArray189 {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        if(k == 0) {
            return;
        }

        int swapCount = 0;

        for(int i = 0; i <= nums.length - 1; i++) {
            if(swapCount == nums.length) {
                break;
            }

            int lastIndex = i;
            int lastIndexValue = nums[lastIndex];
            int tempLoopCount = 0;
            while(swapCount < nums.length && !(tempLoopCount != 0 && lastIndex == i)) {//TODO check equals
                int destIndex = (lastIndex + k > nums.length - 1) ? (lastIndex + k - nums.length)
                        : lastIndex + k;
                lastIndex = destIndex;
                int temp = nums[destIndex];
                nums[destIndex] = lastIndexValue;
                lastIndexValue = temp;
                ++swapCount;
                ++tempLoopCount;
            }
        }
    }

    public static void main(String[] args) {
        RotateArray189 sol = new RotateArray189();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        sol.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
