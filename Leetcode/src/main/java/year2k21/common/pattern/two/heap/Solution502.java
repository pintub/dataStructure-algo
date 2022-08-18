package year2k21.common.pattern.two.heap;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution502 {

    /**
     * Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
     * Output: 6
     *
     * 1. Build MinHeap with capital[]
     * 2. For current "w" i.e. capital, remove all elements from meap while minElem <= currentW and find maxProfit of
     * those elements
     * 3. w = w + maxProfit
     * 4. Repeat Step 2 and 3 from count  1 to k
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (k == 0 || profits == null || profits.length == 0) {//capital[] size same as profits[]
            return 0;
        }
        if(capital.length != profits.length) {
            throw new IllegalArgumentException("Illegal args");
        }

        List<Pair> pairList = IntStream.range(0, capital.length).mapToObj(index -> new Pair(capital[index], profits[index]))
                .collect(Collectors.toList());
        Queue<Pair> minHeap = new PriorityQueue<>(pairList);

        Queue<Pair> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.profit, o1.profit));

        for(int count=1; count <= k ; count++){
            while (minHeap.size() > 0 && minHeap.peek().getCapital() <= w) {
                maxHeap.add(minHeap.poll());
            }
            if(maxHeap.size() == 0) {
                break;
            }
            w = w + maxHeap.poll().getProfit();
            /*while (maxHeap.size() > 0) { //No required , as previous maxHeap values still valid
                minHeap.add(maxHeap.poll());
            }*/
        }

        return w;
    }

    public static void main(String[] args) {
        System.out.println(new Solution502().findMaximizedCapital(3, 0, new int[]{2,2,3,4}, new int[]{0,1,2,0}));
    }

    static class Pair implements Comparable<Pair>{
        private int capital;
        private int profit;

        public int getCapital() {
            return capital;
        }

        public int getProfit() {
            return profit;
        }

        public Pair(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.capital, o.capital);
        }
    }
}
