import java.util.Arrays;

public class Solution1475 {

    //Brute Force
    public int[] finalPrices(int[] prices) {
        int size = prices.length;

        for(int i = 0 ; i < size ; i++){
            for(int j = i+1; j < size ; j++){
                int diff = prices[i] - prices[j];
                if(diff >= 0){
                    prices[i] = diff;
                    break;
                }
            }
        }
        return prices;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1475().finalPrices(Util.createArray(10,1,1,6))));
    }
}
