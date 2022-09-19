package com.p2.sort;

import java.util.Arrays;

/**
 * Also refer @link{{{@link MergeLL}}} for Linked-list Mergesort
 *
 * How Time= nlogn
 *      T(n) = 2T(n/2) + θ(n)
 *      Merging happens only logn times & each merging takes approx O(n)
 */
public class Merge {

    public static void sort(int[] input){
        sort(input, 0, input.length-1);
    }

    private static void sort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }

        int mid = (low + high) / 2; //floor
        sort(arr, low, mid);
        sort(arr, mid+1, high);

        mergeSortedArray(arr, low, mid, high);
    }

    /**
     * Extra or Auxiliary space needed
     */
    private static void mergeSortedArray(int[] arr, int low, int mid, int high){
        int size = high - low + 1;
        int[] output = new int[size];
        int i=low;//Array 1 pointer
        int j=mid+1;//Array 2 pointer
        int outputCounter = 0;

        //Triple while loops
        while (i<=mid && j<=high){
            if(arr[i] <= arr[j]){
                output[outputCounter++] = arr[i];
                i++;
            } else {
                output[outputCounter++] = arr[j];
                j++;
            }
        }

        while (i <= mid){
            output[outputCounter++] = arr[i];
            i++;
        }

        while (j <= high){
            output[outputCounter++] = arr[j];
            j++;
        }

        for (int count=0; count<size; count++){//copy from auxiliary space to original array
            arr[low+count]=output[count];
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2 ,4, 7, 3, 5, 9, 10, 2, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
