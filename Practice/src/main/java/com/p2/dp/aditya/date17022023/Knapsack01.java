package com.p2.dp.aditya.date17022023;

/**
 * Space optimization = O(1 * W)
 */
public class Knapsack01 {

    private int getMaxProfit(int[] weight, int[] value, int maxCapacity) {

        int itemLen = value.length;

        //Virtual Matrix of capacity vs item
        int[] memo = new int[maxCapacity + 1];//[0..maxCapacity]
        for(int col = 0; col <= itemLen; col++) {
            for(int row = maxCapacity; row >= 0; row--) {
                if(col == 0) {
                    memo[row] = 0;
                    continue;
                }

                if(row == 0){
                    continue;
                }

                memo[row] = Math.max(
                        memo[row],
                        row >= weight[col - 1] ? value[col - 1] + memo[row - weight[col - 1]] : 0
                );
            }
        }
        return memo[maxCapacity];
    }

    public static void main(String[] args) {
        int[] value = new int[] {1, 4, 5, 7};
        //int[] value = new int[] {60, 100, 120};
        int[] weight = new int[] {1, 3, 4, 5};
        //int[] weight = new int[] {10, 20, 30};
        int maxCapacity = 7; //O/P = 9
        //int maxCapacity = 50;//O/P = 220

        System.out.println(new Knapsack01().getMaxProfit(weight, value, maxCapacity));
    }
}
