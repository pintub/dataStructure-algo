package year2k21.common.pattern.general.stockbuysell;

// O(n) Single-Pass solution below copied from https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/1735493/JavaC%2B%2B-best-ever-EXPLANATION-could-possible
public class BestTimeToBuyAndSellStockOnlyOnce121 {

    public int maxProfit(int[] prices) {
        int leastSoFar = Integer.MAX_VALUE;
        int overallProfit = 0;
        int profitIfSoldToday = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < leastSoFar){//If lower price found
                leastSoFar = prices[i];
            }
            profitIfSoldToday = prices[i] - leastSoFar;
            overallProfit  = Math.max(overallProfit, profitIfSoldToday);
        }
        return overallProfit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockOnlyOnce121().maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
