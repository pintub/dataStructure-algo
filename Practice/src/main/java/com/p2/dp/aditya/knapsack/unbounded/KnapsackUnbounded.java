package com.p2.dp.aditya.knapsack.unbounded;

/**
 * Space Optimization:
 *      Assume memo[][] -> row is [0..maxCapacity] and column having [0..arraySize]
 *      Value at any cell depends on just-left cell and current column upper cells, SO we can just use O(W)
 */
public class KnapsackUnbounded {

    //Space = O(W)
    private int getMaxProfit(int[] weight, int[] value, int maxCapacity) {
        int[] memo = new int[maxCapacity + 1];

        for(int column = 1; column <= value.length; column++) {//Virtual columns, not columns of optimized-memo[], Code by seeing diagram of table, and thinking of space optimization
            for(int row = 1; row <= maxCapacity; row++) {//Columns of optimized-memo[]
                if (column == 0 || row == 0) {//No need anymore as row, col starts with 1
                    continue;
                }
                memo[row] = Math.max(
                        //Including current weight
                        row - weight[column - 1] >= 0 ? (memo[row - weight[column - 1]] + value[column - 1]) : 0
                        //Excluding weight
                        , memo[row]);
            }
        }

        return memo[maxCapacity];
    }

    public static void main(String[] args) {
        System.out.println(new KnapsackUnbounded().getMaxProfit(new int[] {1, 50}, new int[]{1, 30}, 100) == 100);
        System.out.println(new KnapsackUnbounded().getMaxProfit(new int[] {1, 3, 4, 5}, new int[]{10, 40, 50, 70}, 8) == 110);

    }
}
