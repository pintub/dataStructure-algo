package com.p2.dp.aditya;

import java.util.HashMap;
import java.util.Map;

/**
 * Input :{-2, -3, 4, -1, -2, 1, 5, -3}
 * Output: 7 for continuous subArray {4, -1, -2, 1, 5}
 *
 * Type 3 recursion, Piggy-backing getMaxSumStartingAtIndex()
 *
 * getMaxSumStartingAtIndex(idx) = Max (arr[idx], arr[idx] + getMaxSumStartingAtIndex(idx+1))
 *
 * Traverse array left to right
 *
 * Maintain global var for largestSumContinuousArray
 *
 * Time = O(n)
 * Space = O(1)
 */
public class LargestSumContinuousArrayKadane {
    private int largestSumContinuousArray = Integer.MIN_VALUE;

    public int getLargestSumContinuousArray(int[] arr) {
        Map<Integer, Integer> memoStartingIndexVsMaxSumSFromStartingIndex = new HashMap<>();
        getMaxSumStartingAtIndex(0, arr, memoStartingIndexVsMaxSumSFromStartingIndex);

        return largestSumContinuousArray;
    }

    private int getMaxSumStartingAtIndex(int idx, int[] arr, Map<Integer, Integer> memoStartingIndexVsMaxSumSFromStartingIndex) {
        if(idx > arr.length - 1) {
            largestSumContinuousArray = Math.max(largestSumContinuousArray , 0);
            memoStartingIndexVsMaxSumSFromStartingIndex.put(idx, 0);
            return 0;
        }

        int result = Math.max(arr[idx],
                arr[idx] + getMaxSumStartingAtIndex(idx + 1, arr, memoStartingIndexVsMaxSumSFromStartingIndex)
        );

        memoStartingIndexVsMaxSumSFromStartingIndex.put(idx, result);
        largestSumContinuousArray = Math.max(largestSumContinuousArray, result);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LargestSumContinuousArrayKadane().getLargestSumContinuousArray(new int[] {-2, -3, 4, -1, -2, 1, 5, -3}) == 7);
    }
}
