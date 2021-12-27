package com.p2.sort;

import java.util.Arrays;

/**
 * When a Range of elements present, i.e. Range = O(n), not n^2
 * Not comparison-based sorting
 * Time = O(n+k), k is count[] array size
 * Space = O(n+k)
 */
public class Counting {

    static void sort(int[] input){
        int[] count = new int[10];//Digits 0 to 1
        int[] output = new int[input.length];

        for(int i=0; i<input.length; i++){//Populate count array
            ++count[input[i]];
        }

        for(int j=1; j<=9; j++){//After this for loop , count[] defines position of numbers in output array
            count[j]=count[j]+count[j-1];
        }

        for(int i=input.length-1; i>=0; i--){
            output[--count[input[i]]]=input[i];
        }

        for(int i=0; i<input.length; i++){
            input[i]=output[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 5, 4, 3, 0, 1, 4, 5};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
