import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Solution1475 {

    //Brute Force
    public int[] finalPricesV2(int[] prices) {
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

    //Leetcode Best solution(Using monotone stack/increasing stack)
    public int[] finalPricesV3(int[] ps) {
        int n = ps.length, res[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && ps[i] < st.peek()) st.pop();
            res[i] = ps[i] - (st.isEmpty() ? 0 : st.peek());
            st.push(ps[i]);
        }
        return res;
    }

    //ArrayDeque as Stack
    public int[] finalPrices(int[] prices) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while (!st.isEmpty() && prices[i] <= prices[st.peek()]) {
                res[st.pop()] -= prices[i];
            }
            res[i] = prices[i];
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1475().finalPrices(Util.createArray(10,1,1,6))));
    }
}
