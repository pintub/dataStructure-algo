package com.p2.dp.aditya;

import java.util.*;

/**
 *
 * Type 3 piggyback getListStartWithIndex() and calc LIS-list using global var
 *
 * Example , input = {10, 22, 9, 33, 21, 50, 41, 60, 80}, o/p= LIS is {10, 22, 33, 50, 60, 80}.
 * Approach1
 * DP Choice
 *                            10(Starts with 10, index= 0)              22(Starts with 22)         9(Starts with 9)
 *                              /                                                                    \
 *                          (find >10)                                                              (>9)
 *  *                 /   /   \  |  \                                                             /   /   \  |  \  \
 *                 22   33   50  60  80                                                          33  21  50  21 60 80
 * Approach2
 *      Transform & Conquer
 *      Convert to LCS
 *      LCS(array[], sortedUniqueElementsArray[])
 *      Time = O(n^2) [i.e. n cells , for each cell a for loop] ,Space =O(n^2)
 *      So Approach1 is optimized as Space there = O(n)
 */
public class LongestIncreasingSubsequence {

    private List<Integer> largestLIS = new ArrayList<>();

    List<Integer> printLIS(int[] arr) {
        List<Integer>[] memo = new List[arr.length];

        printLIS(0, arr, memo);

        return largestLIS;
    }

    private List<Integer> printLIS(int startIndex, int[] arr, List<Integer>[] memo) {
        if(memo[startIndex] != null) {
            return memo[startIndex];
        }

        if(startIndex > arr.length - 1){
            memo[startIndex] = Collections.emptyList();
            if(memo[startIndex].size()  > largestLIS.size()) {//Piggybacking
                largestLIS = memo[startIndex];
            }
            return memo[startIndex];
        }

        int currentElement = arr[startIndex];
        if(startIndex == arr.length - 1){//Starts w/ last element
            memo[startIndex] = Collections.singletonList(currentElement);
            if(memo[startIndex].size()  > largestLIS.size()) {//Piggybacking
                largestLIS = memo[startIndex];
            }
            return memo[startIndex];
        }

        List<Integer> maxList = new ArrayList<>();
        maxList.add(currentElement);
        //Starts w/ current index, So check all elements > currElement
        for(int idx = startIndex + 1; idx < arr.length; idx++) {
            List<Integer> temp = new ArrayList<>();
            if(arr[idx] > currentElement) {
                temp.add(currentElement);
                temp.addAll(printLIS(idx, arr, memo));

                if(temp.size() > maxList.size()) {
                    maxList = temp;
                }
            }
        }
        //Run the same logic for start with next index, No need to do anything with its result as current loop means list starting with current index
        printLIS(startIndex + 1, arr, memo);

        memo[startIndex] = maxList;//Memorization

        if(memo[startIndex].size()  > largestLIS.size()) {//Piggybacking
            largestLIS = memo[startIndex];
        }
        return memo[startIndex];
    }

    public static void main(String[] args) {
        //System.out.println(new LongestIncreasingSubsequence().printLIS(new int[]{3, 10, 2, 1, 20}).equals(Arrays.asList(3, 10, 20)));
        System.out.println(new LongestIncreasingSubsequence().printLIS(new int[]{0}));
    }
}
