package com.p2.sort;

import java.util.Arrays;

/**
 * Note, Read counting sort first
 * =================================
 * Radix using counting sorting, why?because we deal with digits and count[] size will be max 10
 * When Range = O(n^2) , when Big numbers are there
 * Example Dataset : {101, 802, 4, 121, 308, 101}
 *
 * Overhead:
 *      Number of bits of max element * O(n+k) & k=10
 */
public class Radix {
    static void sort(int[] input){
        int max = getMax(input);//Find Max of input numbers, this can be also used in Counting array to reduce count[] size
        for(int pos=1; (max/pos)>0; pos=pos*10){//1st sort numbers by count sorting based on LSB, then middle-SB, then MSB, i.e. pos 1, then 10, then 100 if max number is 3 digits
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
        int[] count = new int[10];//Digits count is 10 , i.e. 0 to 9
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

        //LSB Sorting
        //count[]       {0, 3, 1, 0, 1, 0, 0, 0, 1}
        //new count[]   {0, 3, 4, 4, 5, 5, 5, 5, 6}
        //{101, 121, 101, 802, 4, 308}  //Output based on LSB


        //101 101 802 308 4 121         //Output based on Middle-SB

        //4 101 101 121 308 802         //Output based on MSB

    }
}
