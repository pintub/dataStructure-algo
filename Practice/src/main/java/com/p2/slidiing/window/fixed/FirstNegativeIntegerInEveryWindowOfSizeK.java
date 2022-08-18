package com.p2.slidiing.window.fixed;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
public class FirstNegativeIntegerInEveryWindowOfSizeK {

    public long[] printFirstNegativeInteger(long array[], int windowSize) {
        //TWO Pointers
        int left = 0;
        int right = 0;

        long[] result = new long[array.length - windowSize + 1];
        int resultCount = 0;

        //Memorization
        Queue<Integer> queue = new LinkedList<>();

        while (right < array.length) {
            if(array[right] < 0) {
                queue.add(right);
            }

            if(right - left + 1 < windowSize) {//If Window size not yet attained
                right++;
            } else if(right - left + 1 == windowSize) {
                right++;
                left++;

                result[resultCount] = !queue.isEmpty() ? array[queue.peek()] : 0;
                if(!queue.isEmpty() && queue.peek() < left) {
                    queue.remove();
                }
                resultCount++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FirstNegativeIntegerInEveryWindowOfSizeK().printFirstNegativeInteger(new long[]{-8, 2, 3, -6, 10}, 2)));
    }
}
