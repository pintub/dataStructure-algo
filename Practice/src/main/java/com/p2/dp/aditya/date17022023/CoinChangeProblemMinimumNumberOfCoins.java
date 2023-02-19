package com.p2.dp.aditya.date17022023;

//Space-Optimized
//memo_size = O(targetSum + 1)
public class CoinChangeProblemMinimumNumberOfCoins {

    /**
     * row side -> coins
     * column side - > target sum
     */
    public int minCoins(int targetSum, int[] coins) {
        int coinLen = coins.length;
        int[] memo = new int[targetSum + 1];

        for (int col = 0; col <= coinLen; col++) {
            for (int row = 0; row <= targetSum; row++) {
                if(col == 0) {
                    memo[row] = Integer.MAX_VALUE;
                    continue;
                }

                if(row == 0) {
                    memo[row] = 0;
                    continue;
                }
                //row -> currentCapacity
                memo[row] = Math.min(
                        //Include
                        (row >= coins[col - 1]) ?
                                (memo[row - coins[col - 1]] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : (1 + memo[row - coins[col - 1]])
                            : Integer.MAX_VALUE     ,
                        //Exclude
                        memo[row]
                );
            }
        }

        return memo[targetSum];
    }

    public static void main(String[] args) {
        CoinChangeProblemMinimumNumberOfCoins sol = new CoinChangeProblemMinimumNumberOfCoins();
        //System.out.println(sol.minCoins(30, new int[]{25, 10, 5})); //2
        //System.out.println(sol.minCoins(11, new int[]{9, 6, 5, 1})); //2
        System.out.println(sol.minCoins(15, new int[]{4, 3, 2, 6})); //3
    }
}
