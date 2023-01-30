package year2k21.common.pattern.heap.date24012023;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Read solution 1st
 *
 * After solution reading ->
 *      Pair can store <Capital, Profit> instead of storing index
 *      capitalAndIndexMinHeap would be "asc" order of capital
 *      profitAndIndexMaxHeap would be "desc" order of profit
 */
public class IPO502 {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<Pair<Integer, Integer>> capitalAndIndexMinHeap =
                new PriorityQueue<>(Comparator.comparingInt((Pair<Integer, Integer> pair) -> pair.left));
        for(int index = 0; index < capital.length; index++) {//O(nlogn)
            capitalAndIndexMinHeap.add(new Pair<>(capital[index], index));
        }

        Queue<Pair<Integer, Integer>> profitAndIndexMaxHeap = new PriorityQueue<>((pair1, pair2) -> Integer.compare(pair2.left, pair1.left));

        for(int kCount = 0; kCount < k; kCount++){
            while (!capitalAndIndexMinHeap.isEmpty() && capitalAndIndexMinHeap.peek().left <= w) {
                Pair<Integer, Integer> removed = capitalAndIndexMinHeap.poll();
                profitAndIndexMaxHeap.add(new Pair<>(profits[removed.right], removed.right));
            }

            if(profitAndIndexMaxHeap.isEmpty())
                break;

            w += profitAndIndexMaxHeap.remove().left;
        }

        return w;
    }

    static class Pair<L, R> {
        public L left;
        public R right;

        public Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return left.equals(pair.left) && right.equals(pair.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }

    public static void main(String[] args) {
        System.out.println(new IPO502().findMaximizedCapital(3, 0, new int[]{1,2,3}, new int[]{0,1,2}));
    }
}
