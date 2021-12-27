package com.p2.sort;

import java.util.Arrays;

public class Selection {

    static void sortDesc(int[] input) {
        if (input == null) {
            throw new IllegalArgumentException("Input is Null");
        }

        for(int i=0; i<input.length-1; i++){
            int largestIndx = i;
            for(int j=i+1; j<input.length; j++){
                if(input[largestIndx] < input[j]){
                    largestIndx = j;
                }
            }
            //swap arr[i] & arr[largestIndx]
            swap(input, i, largestIndx);
        }

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 5, 1, 2, 4};
        sortDesc(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] array, int i, int j){
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }
}
