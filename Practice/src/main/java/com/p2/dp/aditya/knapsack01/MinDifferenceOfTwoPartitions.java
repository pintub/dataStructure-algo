package com.p2.dp.aditya.knapsack01;

import java.util.Arrays;

/**
 * S1 - S2 ≈ 0
 * =>S1 - (arraySum - S1) ≈ 0
 * =>2S1 - arraySum ≈ 0
 * =>S1 ≈ arraySum/2 => At each node of recursion-tree, Return min(|subSetSum - arraySum/2|)
 *
 *
 * Note on Solution:
 *  Aditya has used tabulation result of canSum and built solution on top of that
 *
 *  How to do memorization:
 *      Same technique as canSum(), using dp(index, sum as ArraySum)
 *      Include or Don't include an element
 *
 *      When index=0, you get end of array and get an "sum" at the "leaf"
 *      Compute 2Sum - ArraySum and return
 *
 *      At intermediate node,min of these value wins and returned to parent
 *
 */
public class MinDifferenceOfTwoPartitions {

    int dp(int index, int sum, final int totalSum, final int[] input, int[][] memo) {
        if(memo[index][sum] != Integer.MIN_VALUE) {
            return memo[index][sum];
        }
        if(index == 0) {
            memo[index][sum] = Math.abs(totalSum - 2 * sum);
            return memo[index][sum];
        }

        memo[index][sum] =
                Math.min(
                    //Take
                        dp(index - 1, sum - input[index-1], totalSum, input, memo),
                    //Do not Take
                        dp(index - 1, sum, totalSum, input, memo)
                );
        return memo[index][sum];
    }

    public static void main(String[] args) {
        int[] input = {1, 6, 11, 5};
        MinDifferenceOfTwoPartitions sol = new MinDifferenceOfTwoPartitions();

        int totalSum = Arrays.stream(input).sum();

        int[][] memo = new int[input.length + 1][totalSum + 1];
        for(int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        System.out.println(sol.dp(input.length, totalSum, totalSum, input, memo));
    }
}
