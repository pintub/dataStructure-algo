package com.p2.sort;

import java.util.Arrays;

/**
 * Fits for incoming stream of integers
 * Intuition:
 *      1st part of array is already sorted
 *      Insert the element in sorted-array, like putting a card in sorted deck of cards
 */
public class Insertion {

    static void sort(int[] input) {
        if (input == null) {
            throw new IllegalArgumentException("Input is Null");
        }

        for(int i=0; i<input.length-1; i++){
            int j=i+1;
            int tmp = input[j];
            while(j>0 && input[j-1] > tmp){//Come Right to left & avoid shifting of large number of elements at one go
                input[j] = input[j-1];
                j--;
            }

            input[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 1 , 4, 1, 15, 7, 2, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
