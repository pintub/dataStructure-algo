package com.p2.random.gfg;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/given-two-sorted-arrays-number-x-find-pair-whose-sum-closest-x/amp/
 */
public class FindTheClosestPairFromTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(FindTheClosestPairFromTwoSortedArrays.solve(new int[]{1 , 4 , 5 , 7} , new int[]{10 , 20 , 30 , 40} , 50)));
    }

    private static int[] solve(int[] arr1, int[] arr2, int x) {
        int left = 0;
        int right = arr2.length - 1;

        int minDiff = Integer.MAX_VALUE;
        int[] resultIndex = new int[]{-1, -1};

        while (left <= arr1.length - 1 && right >= 0) {
            if(arr1[left] + arr2[right] == x) {
                return new int[]{arr1[left], arr2[right]};
            }

            minDiff = compareAndSetMinDiff(arr1 , arr2 , x , left , right , minDiff , resultIndex);

            if (arr1[left] + arr2[right] > x) {
                --right;
            } else {
                ++left;
            }
        }

        while(left <= arr1.length - 1){
            if(arr1[left] + arr2[0] == x) {
                return new int[]{arr1[left], arr2[0]};
            }

            minDiff = compareAndSetMinDiff(arr1 , arr2 , x , left , 0 , minDiff , resultIndex);

            ++left;
        }

        while(right >= 0){
            if(arr1[arr1.length - 1] + arr2[right] == x) {
                return new int[]{arr1[arr1.length - 1], arr2[right]};
            }

            minDiff = compareAndSetMinDiff(arr1 , arr2 , x , arr1.length - 1 , right , minDiff , resultIndex);

            --right;
        }

        return new int[]{arr1[resultIndex[0]], arr2[resultIndex[1]]};
    }

    private static int compareAndSetMinDiff(int[] arr1 , int[] arr2 , int x , int left , int right , int minDiff , int[] resultIndex) {
        int diff = Math.abs(arr1[left] + arr2[right] - x);
        if(diff < minDiff) {
            minDiff = diff;
            resultIndex[0] = left;
            resultIndex[1] = right;
        }
        return minDiff;
    }
}
