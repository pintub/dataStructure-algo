package com.p2.dp.aditya;

import java.util.*;

/**
 * Example , input = {10, 22, 9, 33, 21, 50, 41, 60, 80}, o/p= LIS is {10, 22, 33, 50, 60, 80}.
 * Approach1
 *                      10
 *                 /(incl)      \(excl)
 *                /(Find >10)    \(Find <=10)
 *               /                \
*              /                   \
*                22                9
 *           / (incl)   \(excl)
 *          /(Find >22)  \(Still
 *         /              \Find >10)
 *        33              33
 * Approach2
 *      Transform & Conquer
 *      Convert to LCS
 *      LCS(array[], sortedUniqueElementsArray[])
 *      Time = O(n^2) [i.e. n cells , for each cell a for loop] ,Space =O(n^2)
 *      So Approach1 is optimized as Space there = O(n)
 */
public class LongestIncreasingSubsequence {

    List<Integer> printLIS(int[] arr) {
        List<Integer>[] memo = new List[arr.length];

        return printLIS(0, arr, memo, Integer.MIN_VALUE);
    }

    private List<Integer> printLIS(int arrIndex, int[] arr, List<Integer>[] memo, int previousElementIncreasingSS) {
        if(memo[arrIndex] != null) {
            return memo[arrIndex];
        }

        if(arrIndex > arr.length - 1){
            memo[arrIndex] = Collections.emptyList();
            return Collections.emptyList();
        }

        if(arrIndex == arr.length - 1){
            memo[arrIndex] = Collections.singletonList(arr[arr.length - 1]);
            return memo[arrIndex];
        }

        int currentElement = arr[arrIndex];

        List<Integer> list1 = new ArrayList<>();
        //Include currentElement
        for(int idx= arrIndex+1; idx <= arr.length - 1; idx++) {//Find next > currentElement
            if(arr[idx] > currentElement) {
                list1.add(currentElement);
                list1.addAll(printLIS(idx, arr, memo, currentElement));
                break;
            }
        }
        List<Integer> list2 = new ArrayList<>();
        //Exclude currentElement
        for(int idx= arrIndex+1; idx <= arr.length - 1; idx++) {//Find next < currentElement AND > previousElementIncreasingSS
            if(arr[idx] > previousElementIncreasingSS && arr[idx] < currentElement) {
                list2.addAll(printLIS(idx, arr, memo, currentElement));
                break;
            }
        }

        memo[arrIndex] = (list1.size() > list2.size()) ? list1 : list2;
        return memo[arrIndex];
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().printLIS(new int[]{3, 10, 2, 1, 20}).equals(Arrays.asList(3, 10, 20)));
        System.out.println(new LongestIncreasingSubsequence().printLIS(new int[]{50, 3, 10, 7, 40, 80}).equals(Arrays.asList(3, 7, 40, 80)));
    }
}
