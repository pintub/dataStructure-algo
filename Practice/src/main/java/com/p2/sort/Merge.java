package com.p2.sort;

import java.util.Arrays;

/**
 * Suitable for linkedlist
 * 1. mid of list using slow and fast pointer
 *
 */
public class Merge {

    static void sort(int[] input){
        sort(input, 0, input.length-1);
    }

    static void sort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }

        int mid = (low + high) / 2; //floor
        sort(arr, low, mid);
        sort(arr, mid+1, high);

        mergeSortedArray(arr, low, mid, high);
    }

    static void mergeSortedArray(int[] arr, int low, int mid, int high){
        int size = high - low + 1;
        int[] output = new int[size];
        int i=low;//Array 1 pointer
        int j=mid+1;//Array 2 pointer
        int outputCounter = 0;

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

        for (int count=0; count<size; count++){
            arr[low+count]=output[count];
        }

        //k=1
        //3(i)->4
        //1(k)->2(j)->5->6

        //1->3->4
        //5->6

        //

    }

    public static void main(String[] args) {
        int[] arr = {1, 2 ,4, 7, 3, 5, 9, 10, 2, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
