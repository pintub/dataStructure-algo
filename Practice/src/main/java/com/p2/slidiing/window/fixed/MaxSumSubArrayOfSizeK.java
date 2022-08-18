package com.p2.slidiing.window.fixed;

import java.util.*;

/**
 * Fixed window
 * Question : https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
 */
public class MaxSumSubArrayOfSizeK {

    static long maximumSumSubArray(int windowSize, List<Integer> array){
        //TWO Pointers
        int left = 0;
        int right = 0;

        //Memorization
        long maxSum = Long.MIN_VALUE;
        long tempSum = 0;

        while (right < array.size()) {//Need to remember this, Outer loop condition

            //Fixed size question, so increment Right pointer until window size is formed
            if (right - left + 1 < windowSize) {
                tempSum += array.get(right);//Update Memorization by adding Right pointer based on Question
                right++;
            } else if(right - left + 1 == windowSize) {//Once window size achieved, maintain the same size by incrementing left and right pointers, This is where window of [left..right] is of size = windowSize
                tempSum += array.get(right);//Update Memorization by adding Right pointer based on Question, Note this is repeated code, same as that of if() clause logic
                right++;

                maxSum = Math.max(maxSum, tempSum); //Result Calculation

                tempSum -= array.get(left); //Update Memorization by removing Left pointer based on Question
                left++;

            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(MaxSumSubArrayOfSizeK.maximumSumSubArray(3, Arrays.asList(100, 200, 300, 400)));
    }
}
