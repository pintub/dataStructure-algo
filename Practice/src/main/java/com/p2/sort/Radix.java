package com.p2.sort;

import java.util.Arrays;

/**
 * Radix using counting sorting
 * When Range = O(n^2)
 */
public class Radix {
    static void sort(int[] input){
        int max = getMax(input);
        for(int pos=1; (max/pos)>0; pos=pos*10){//1st sort numbers by count sorting based on LSB, then middle-SB, then MSB
            countSort(input, pos);
        }
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

    static void countSort(int[] input, int pos){//Count sort elements based on position, first LSB till MSB
        int[] count = new int[10];
        int[] output = new int[input.length];
        for(int i=0; i<input.length; i++){
            ++count[(input[i]/pos)%10];
        }

        for(int j=1; j<=9; j++){
            count[j]=count[j]+count[j-1];
        }

        for(int i=input.length-1; i>=0; i--){
            output[--count[(input[i]/pos)%10]]=input[i];
        }

        for(int i=0; i<input.length; i++){
            input[i]=output[i];
        }

    }

    public static void main(String[] args) {
        int[] arr ={101, 802, 4, 121, 308, 101};
        sort(arr);
        System.out.println(Arrays.toString(arr));


        //{101, 121, 101, 802, 4, 308}
        //101 101 802 308 121 4
        //4 101 101 121 308 802

        //count   [0, 3, 1, 0, 1, 0, 0, 0, 1]
        //position[0, 3, 4, 4, 5, 5, 5, 5, 6]

        //output []

        //0
        //1 101 121 101
        //2 802
        //4 4
        //9

        //0-2 2 1
        //3-5 5 3


    }
}
