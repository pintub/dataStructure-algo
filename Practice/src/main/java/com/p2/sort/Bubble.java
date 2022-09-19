package com.p2.sort;

import java.util.Arrays;

/**
 * For each outer-loop "i", Current & Next element comparison
 * Optimization: No no swapping in any iteration, then already Sorted
 */
public class Bubble {

    static void sort(int[] input) {
        if (input == null) {
            throw new IllegalArgumentException("Input is Null");
        }

        for(int i=0; i<input.length - 1; i++){
            boolean swapped = false;

            for(int j=0; j < input.length -i -1 ; j++){//Right most part where max are positioned needs not be compared
                //Compare input[j] and input[j+1] and swap
                if(input[j] > input[j+1]) {
                    swap(input, j, j + 1);
                    swapped = true;
                }
            }

            if(!swapped)
                break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 1, 2, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] array, int i, int j){
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

}
