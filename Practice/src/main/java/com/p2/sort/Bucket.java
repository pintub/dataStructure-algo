package com.p2.sort;

import java.util.*;

/**
 * When Range of elements present and counting not possible
 * Or fractional number
 * Note: Counting algo uses count[] with index as element and value as frequency
 */
public class Bucket {

    static void sort(int[] input){
        int max = getMax(input);
        int min = getMin(input);
        int range = (max - min)/(input.length);
        LinkedList<Integer>[] bucket = new LinkedList[((max-min)/range)+1];

        for(int count=0; count<bucket.length; count++){
            bucket[count] = new LinkedList<>();
        }

        for(int i=0; i<input.length; i++){
            bucket[(input[i] - min) / range ].add(input[i]);
        }

        for(LinkedList<Integer> list : bucket){
            Collections.sort(list); //Uses another sorting within bucket
        }

        int[] output = new int[input.length];
        int outputCounter = 0;
        for(LinkedList<Integer> list : bucket){
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
