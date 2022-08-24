package com.p2.dp.aditya.knapsack01;

/**
 * nums[] = {1, 1, 2, 3}
 * targetSum = 1
 *
 * Approach1 :
 *      Choice is to assign - or + for a given element
 *      memo[][] -> L'll complex as row can contain -ve number & column is arrayIndex
 *
 * Approach2(Transform and conquer):
 *      One possibility = {+1, -1, -2, +3}
 *      So, S1 - S2 = diff
 *      Now problem reduced to {@link CountWaysOfTwoPartitionsWithGivenDifference}
 */
public class CountWaysOfTargetSumUsingPlusMinusSigns {
}
