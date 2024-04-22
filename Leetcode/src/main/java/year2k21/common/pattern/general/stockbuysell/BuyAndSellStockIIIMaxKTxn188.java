package year2k21.common.pattern.general.stockbuysell;

/**
 * Extension of {{@link BuyAndSellStockIIIMax2Txn123}}
 */
public class BuyAndSellStockIIIMaxKTxn188 {

    //Going left to right
    public int maxProfit(int k, int[] prices) {
        int[] memo = new int[2 * k + 1];//max k txns, so 2*k actions

        for(int i = prices.length; i >= 0; i--) {
            int prevStoredValInRow = 0;
            for(int j = 2*k; j >= 0; j--) {
                if(j == 2*k || i == prices.length) {
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

}
