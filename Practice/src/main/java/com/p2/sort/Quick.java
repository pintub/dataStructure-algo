package com.p2.sort;

import java.util.Arrays;

import static com.p2.sort.Bubble.swap;

public class Quick {

    static void sort(int[] input){
        sort(input, 0, input.length-1);
    }

    static void sort(int[] input, int low, int high){
        if(low >= high){
            return;
        }
        int partitionIndex = partition(input, low, high);

        sort(input, low, partitionIndex-1);
        sort(input, partitionIndex+1, high);
    }

    //All lesser element on left side of pivot
    //All larger element on left side of pivot
    //2 pointer pointer, j 0->high-1
    // i tries to keep less elements at left part of array, if bigger element found, it stops ,when next small
    // element found, swaps the values and moves one position
    private static int partition(int[] input, int low, int high) {
        //Set pivot at the end of array
        int pivot = input[high];
        int i = low-1;
        for(int j=low; j<high; j++){
            if(input[j] < pivot){
                i++;
                if(i != j) {
                    swap(input, i, j);
                }
            }
        }
        swap(input, i+1, high);

        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0 , 6, 3, 8, 10, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        //O(nlogn)
        //1, 0 ,4(i,j), 3, 6, 1, 9, 10, 1,  8
        //T(n) = 2T(n/2)

        //{1, 0 , 6, 3, 8, 10, 9}
        //{1, 0, 6, 3, 8} 9 {10}
        //{1, 0, 6, 3} 8  9 {10}
        //{1, 0} 3 {6} 8 9 {10}
        //0 {1} 3 {6} 8 9 {10}

        //0 1 6

    }

}
