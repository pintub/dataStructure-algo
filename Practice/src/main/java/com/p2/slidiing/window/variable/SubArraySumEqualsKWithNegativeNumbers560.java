package com.p2.slidiing.window.variable;

import java.util.HashMap;

//Not Sliding window Problem
public class SubArraySumEqualsKWithNegativeNumbers560 {

    //Intuition if targetSum is Sum[i..j](Notice, this is continuous), Then There are Sum[0..i] & Sum[0..j] where Sum[i..j] = Sum[0..i] - Sum[0..j] => Sum[0..j] =  Sum[0..i] - Sum[i..j]
    //Returns how many windows having sum = targetSum
    //Another Variation of Question is : largest window size many windows having sum = targetSum //https://www.geeksforgeeks.org/longest-sub-array-sum-k/ . Here in map sumTillNowVsIndexWhereSumTillNowHappened
    public int subArraySum(int[] nums, int targetSum) {
        int count = 0, sumTillNow = 0;
        HashMap <Integer, Integer> sumTillNowVsFrequencyOfSumTillNow = new HashMap<>();//sumTillNow naming because we are traversing nums[] and building map and keep cumulative sumTillNow
        sumTillNowVsFrequencyOfSumTillNow.put(0, 1);//WHOAA!!! If Number itself is present in the Array

        for (int i = 0; i < nums.length; i++) {
            sumTillNow += nums[i];

            count += sumTillNowVsFrequencyOfSumTillNow.getOrDefault(sumTillNow - targetSum, 0);
            sumTillNowVsFrequencyOfSumTillNow.put(sumTillNow, sumTillNowVsFrequencyOfSumTillNow.getOrDefault(sumTillNow, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new SubArraySumEqualsKWithNegativeNumbers560().subArraySum(new int[] {-5, 8, -14, 2, 4, 12}, -5));

//Array Traversal & count, Map State
//Initialize count=0, Map= [<0, 1>]
//Step1 : -5 - (-5)  exists in Map, count=1, Map [<0, 1>, <-5, 1>]
//Step2 : (-5 + 8) - (-5)  Not exists in Map, Map [<0, 1>, <-5, 1>,<3, 1>]
//Step3 : (-5 + 8 + -14) - (-5)  Not exists in Map, Map [<0, 1>, <-5, 1>,<3, 1>,<-11, 1>]
//Step4 : (-5 + 8 + -14 + 2) - (-5) Not exists in Map, Map [<0, 1>, <-5, 1>,<3, 1>,<-11, 1>,<-9,1>]
//Step5 : (-5 + 8 + -14 + 2 + 4) - (-5)  exists in Map, count=2, Map [<0, 1>, <-5, 2>,<3, 1>,<-11, 1>,<-9,1>]
//Step6 : (-5 + 8 + -14 + 2 + 4 + 12) - (-5) Not exists in Map, Map [<0, 1>, <-5, 2>,<3, 1>,<-11, 1>,<-9,1>,<12,1>]
    }

}
