package year2k21.common.pattern.general;

//Single Txn is to be made for Max profit

/**
 * Refer for cleaner solution {@link year2k21.common.pattern.general.stockbuysell.BestTimeToBuyAndSellStock121}
 */
public class BestTimeToBuyAndSellStock121 {

    public int maxProfit(int[] prices) {
        int buyIndex = 0;
        int sellIndex = 0;

        int maxProfit = 0;

        for(int index=1; index < prices.length; index++) {
            int newBuyIndex = Math.min(prices[buyIndex], prices[index]) ==  prices[buyIndex] ? buyIndex : index;
            if(newBuyIndex == buyIndex) {//Same buyIndex retain, So look for new max Sell index
                sellIndex = Math.max(prices[sellIndex], prices[index]) == prices[sellIndex] ? sellIndex : index;
                maxProfit = Math.max(maxProfit, prices[sellIndex] - prices[buyIndex]);
            } else {//New Sell index, reset sellIndex to current index
                buyIndex = newBuyIndex;
                sellIndex = buyIndex;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock121().maxProfit(new int[]{2, 4, 1}));
    }
}
