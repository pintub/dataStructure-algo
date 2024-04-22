package year2k21.common.pattern.general.stockbuysell;

/**
 * DP
 */
public class BuyAndSellStockIIIMax2Txn123 {

    //Going left to right
    //Savior Post, which helped in intuition for Recursion Formula: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/solutions/1523723/c-four-solutions-recursion-memoization-dp-with-o-n-space-dp-with-o-1-space/
    public int maxProfit(int[] prices) {
        int[] memo = new int[5];//max 2 txns, so 4 actions

        //Check the below ugly handling of Integer.MIN_VALUE not required
        //Why Integer.MIN_VALUE was introduced below? because when coming from right if you SELL-BUY-SELL, but Don't take buy anymore, it will falsely show more profit, which is not valid case
        //While going from left, same scenario, BUY-SELL-BUY, because of 2nd BUY, profit will reduce, and won't give false profit
        for(int i = prices.length; i >= 0; i--) {
            int prevStoredValInRow = 0;
            for(int j = 4; j >= 0; j--) {
                if(j == 4 || i == prices.length) {
                    memo[j] = 0;
                    continue;
                }

                if(j % 2 == 1) {//Sell
                    int temp = Math.max(prevStoredValInRow + prices[i], memo[j]);
                    prevStoredValInRow = memo[j];
                    memo[j] = temp;
                } else {//Buy
                    int temp = Math.max(prevStoredValInRow - prices[i], memo[j]);
                    prevStoredValInRow = memo[j];
                    memo[j] = temp;
                }
            }
        }

        return memo[0];
    }

    public int maxProfit_GoingRightToLeft(int[] prices) {
        int[] memo = new int[5];//max 2 txns, so 4 actions

        for(int i = 0; i <= prices.length; i++) {
            int prevStoredValInRow = 0;
            for(int j = 1; j <= 4; j++) {
                if(i ==0 && j % 2 == 0) {
                    memo[j] = 0;
                    continue;
                } else if (i ==0 && j % 2 == 1){
                    memo[j] = Integer.MIN_VALUE;
                    continue;
                }

                if(j % 2 == 0) {//Sell
                    int temp = -1;
                    if(prevStoredValInRow == Integer.MIN_VALUE) {
                        temp = memo[j];
                    } else if (memo[j] == Integer.MIN_VALUE) {
                        temp = prevStoredValInRow + prices[i-1];
                    } else {
                        temp = Math.max(prevStoredValInRow + prices[i-1], memo[j]);
                    }
                    prevStoredValInRow = memo[j];
                    memo[j] = temp;
                } else {//Buy
                    int temp = -1;
                    if(prevStoredValInRow == Integer.MIN_VALUE) {
                        temp = memo[j];
                    } else if (memo[j] == Integer.MIN_VALUE) {
                        temp = prevStoredValInRow - prices[i-1];
                    } else {
                        temp = Math.max(prevStoredValInRow - prices[i-1], memo[j]);
                    }
                    prevStoredValInRow = memo[j];
                    memo[j] = temp;
                }
            }
        }

        return memo[4];
    }
}
