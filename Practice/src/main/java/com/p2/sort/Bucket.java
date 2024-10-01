package com.p2.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * When Counting Sorting or Radix sorting can not be used :
 *      Huge Range of distinct elements present,sp count[] will take huge space Or fractional numbers in Array
 *
 * Note: Bucket uses another sort to sort elements in the bucket
 *
 * Time = O(l)(log l) + O(n),where l = n/#Buckets

 NOTE: Technically it takes more time than nlogn
 */
public class Bucket {

    static void sort(int[] input){
        int max = getMax(input);
        int min = getMin(input);
        int rangeOfEachBucket = (max - min)/(input.length);
        LinkedList<Integer>[] bucket = new LinkedList[((max-min)/rangeOfEachBucket)+1];//Number of buckets = ((max-min)/rangeOfEachBucket)+1

        for(int count=0; count<bucket.length; count++){
            bucket[count] = new LinkedList<>();
        }

        for(int i=0; i<input.length; i++){//Fill Bucket
            bucket[(input[i] - min) / rangeOfEachBucket].add(input[i]);
        }

        for(LinkedList<Integer> list : bucket){//Sort Bucket
            Collections.sort(list); //Uses another sorting within bucket
        }

        int[] output = new int[input.length];
        int outputCounter = 0;
        for(LinkedList<Integer> list : bucket){//Traverse buckets sequentially and fill output array
            for(int i : list) {
                output[outputCounter++]=i;
            }
        }

        for(int i=0; i<input.length; i++){
            input[i]=output[i];
        }
    }

    private static int getMin(int[] input) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<input.length; i++){
            if(input[i] < min){
                min = input[i];
            }
        }

        return min;
    }

    private static int getMax(int[] input) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<input.length; i++){
            if(max < input[i]){
                max = input[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] array = {11, 33, 30, 12, 20, 11, 15, 19, 20};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
