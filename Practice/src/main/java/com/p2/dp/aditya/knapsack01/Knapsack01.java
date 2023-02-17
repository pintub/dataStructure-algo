package com.p2.dp.aditya.knapsack01;

/**
 * Example :
 * WeightOfItem[] = {1, 3, 4, 5}
 * ValueOfItem[] = {1, 4, 5, 7}
 * maxCapacity W = 7
 *
 * Output : Max Profit ?
 *
 * memo[][] -> row is [0..maxCapacity] and column having [0..arraySize]
 * space = memo[maxCapacity + 1][arraySize + 1]
 *
 * ===============================
 *              (7(maxCapacity), 3(weightIndex)) //Using 1-Indexing
 *                          /           \
 *                     Incl/             \Excl
*                         /               \
 *   (2(maxCapacity), 2(weightIndex))   (7(maxCapacity), 2(weightIndex))
 *
 * Space Optimization :
 *   So, For any given cell only last column values needed , So space complexity can be if 2 columns used O(2W).
 *   *********Below code is for O(2W)*************
 *
 *  But, even further can be optimized to space complexity = O(W)
 */
public class Knapsack01 {

    //Space = O(2W)
    private int getMaxProfit(int[] weight, int[] value, int maxCapacity) {
        int[][] memo = new int[maxCapacity + 1][2];

        for(int column = 1; column <= value.length; column++) {//Virtual columns, not columns of optimized-memo[], Code by seeing diagram of table, and thinking of space optimization
            for(int row = 1; row <= maxCapacity; row++) {//Columns of optimized-memo[]
                if (column == 0 || row == 0) {//No need anymore as row, col starts with 1
                    continue;
                }
                if (column % 2 == 1) {//Odd column index
                    memo[row][1] = Math.max(
                            //Including current weight
                            row - weight[column - 1] >= 0 ? (memo[row - weight[column - 1]][0] + value[column - 1]) : 0
                            //Excluding weight
                        , memo[row][0]);
                } else {
                    memo[row][0] = Math.max(
                            //Including current weight
                            row - weight[column - 1] >= 0 ? (memo[row - weight[column - 1]][1] + value[column - 1]) : 0
                            //Excluding weight
                            , memo[row][1]);
                }
            }
        }

        return (value.length % 2 == 1) ? memo[maxCapacity][1] : memo[maxCapacity][0];
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
