package com.p2.sort;

import java.util.Arrays;

/**
 * Not comparison-based sorting
 * =============================
 * When a Range of elements present, i.e. Range = O(n), not n^2
 * Example {1, 3, 2, 5, 4, 3, 0, 1, 4, 5}, Range of distinct element-> [0, 5 or 9]
 * Time  = O(n+k), k is count[] array size, i.e. equals to whole range-size
 * Space = O(n+k)
 * Best Case Dataset :
 *      Range of distinct elements less and more repetition
 * Why this sorting not always used if linear complexity :
 *      If Big range of data and fewer numbers of that range is used in input array, K comes huge. Usually time complexity importance wins over space complexity(money), but here wasting a lot of space does not make sense
 *
 * Why Traverse (right to left) of input array instead of Alternative is traverse (left to right) of count Array & prepare output array with clumsy logic :
 *      Reason -> To maintain stable sorting
 */
public class Counting {

    /**
     * So 4 for-loops
     */
    static void sort(int[] input){
        int[] count = new int[10];//Digits 0 to 9
        int[] output = new int[input.length];

        for(int i=0; i<input.length; i++){//Populate count array
            ++count[input[i]];
        }

        for(int j=1; j<=9; j++){//After this for loop, count[] defines position of numbers in output array
            count[j]=count[j]+count[j-1];
        }

        for(int i=input.length-1; i>=0; i--){//Traverse (right to left) of input array (Alternative is traverse (left to right) of count Array & prepare output array with clumsy logic)
            output[--count[input[i]]]=input[i];
        }

        for(int i=0; i<input.length; i++){//Copy from output[] to input[]
            input[i]=output[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 5, 4, 3, 0, 1, 4, 5};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
