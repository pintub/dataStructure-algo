package year2k21.common.pattern.heap.date24012023;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Slightly Better Approach wrt addNum() {{@link year2k21.common.pattern.heap.two.Solution295}}
 */
public class FindMedianFromDataStream295 {

    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;

    public FindMedianFromDataStream295() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((item1, item2) -> Integer.compare(item2, item1));
    }

    public void addNum(int num) {
        if(minHeap.size() == maxHeap.size()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if(maxHeap.isEmpty() || minHeap.isEmpty() || maxHeap.peek() <= minHeap.peek()) {
            return;
        }

        //Reaches here iff maxHeap.peek() > minHeap.peek()
        minHeap.add(maxHeap.remove());
        maxHeap.add(minHeap.remove());
    }

    public double findMedian() {
        return maxHeap.isEmpty() ? 0 : (minHeap.isEmpty() || minHeap.size() < maxHeap.size() ? maxHeap.peek() : ((double)maxHeap.peek() + (double)minHeap.peek())/2);
    }

    public static void main(String[] args) {
        FindMedianFromDataStream295 sol = new FindMedianFromDataStream295();
        sol.addNum(1);
        sol.addNum(2);
        System.out.println(sol.findMedian());
        sol.addNum(3);
        System.out.println(sol.findMedian());
    }

}
