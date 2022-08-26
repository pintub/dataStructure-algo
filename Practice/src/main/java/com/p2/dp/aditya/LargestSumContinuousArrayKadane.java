package com.p2.dp.aditya;

/**
 * Type 3 recursion, Piggy-backing getMaxSumStartingAtIndex()
 *
 * getMaxSumStartingAtIndex(idx) = Max (arr[idx], arr[idx] + getMaxSumStartingAtIndex(idx+1))
 *
 * Traverse array left to right
 *
 * Maintain global var for largestSumContinuousArray
 *
 * No memo required here, it is like a DP Tree problem, func(currentPos) depends on func(currentPos + 1)
 *
 * Time = O(n)
 * Space = O(1)
 */
public class LargestSumContinuousArrayKadane {
    private int largestSumContinuousArray = Integer.MIN_VALUE;

    public int getLargestSumContinuousArray(int[] arr) {
        getMaxSumStartingAtIndex(0, arr);

        return largestSumContinuousArray;
    }

    private int getMaxSumStartingAtIndex(int idx, int[] arr) {
        if(idx > arr.length - 1) {
            largestSumContinuousArray = Math.max(largestSumContinuousArray , 0);
            return 0;
        }

        int result = Math.max(arr[idx],
                arr[idx] + getMaxSumStartingAtIndex(idx + 1, arr)
        );

        largestSumContinuousArray = Math.max(largestSumContinuousArray, result);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LargestSumContinuousArrayKadane().getLargestSumContinuousArray(new int[] {-2, -3, 4, -1, -2, 1, 5, -3}) == 7);
    }
}
