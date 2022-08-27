package year2k21.common.pattern.two.heap;

import java.util.*;

/**
 * Insertion sort using Array
 * addNum = O(n) & findMedian = O(1)
 *
 * Using 2 heaps , lower half using Maxheap, Higher half Minheap
 *      minHeap = new PriorityQueue<>();
 *      maxHeap = new PriorityQueue<>(Collections.reverseOrder());
 *
 * if size = odd, maxheap.size = meanheap.size + 1
 * if size = even, maxheap.size = meanheap.size
 *
 * Explanation : https://leetcode.com/problems/find-median-from-data-stream/discuss/1330646/C%2B%2BJavaPython-MinHeap-MaxHeap-Solution-Picture-explain-Clean-and-Concise
 *
 * addNum() = O(logn) & findMedian() = O(1)
 */
public class Solution295 {

    static class MedianFinder {

        private MinHeap minHeap;
        private Queue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new MinHeap();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        /**
         * Balance minHeap and Maxheap if necessary
         */
        public void addNum(int num) {
            if(maxHeap.size() - minHeap.size() == 1) {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            } else {
                minHeap.add(num);
                maxHeap.add(minHeap.peek());
                minHeap.delete(); //MinHeap poll() = peek() + delete() :-D
            }
        }

        public double findMedian() {
            if(maxHeap.size() - minHeap.size() == 1) {
                return maxHeap.peek();
            }

            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

    }

    static class MinHeap {

        private int[] store = new int[100001];//Either of heap stores 10^5 elements
        private int size = 0;

        public int size() {
            return size;
        }

        //Add element
        public void add(int num) {
            store[size] = num;//Add number at end & heapifyUp
            heapifyUp(size);
            ++size;
        }

        public int peek() {
            return store[0];
        }

        //Delete min element
        public void delete() {
            if(size == 0)  {//If no elements
                return;
            }
            if(size == 1)  {//If 1 elements
                store[0] = 0;
                --size;
                return;
            }
            store[0] = store[size-1];//Swap Min and Last value and heapifyDown
            store[size-1] = 0;
            --size;
            heapifyDown(0);
        }

        private void heapifyDown(int index) {
            int leftChildIndex = 2*index + 1;
            int rightChildIndex = 2*index + 2;
            if(leftChildIndex > size-1 && rightChildIndex > size - 1) {//No child exists
                return;
            }

            int minValueIdx = minIndexOfThree(index, leftChildIndex, rightChildIndex);
            if(index == minValueIdx) {
                return;
            }

            swapArrayValues(index, minValueIdx);
            heapifyDown(minValueIdx);
        }

        private int minIndexOfThree(int parentIdx, int childIdx1, int childIdx2) {
            int minIndex = parentIdx;
            if (childIdx1 <= size - 1 && store[childIdx1] < store[minIndex]) {
                minIndex = childIdx1;
            }
            if (childIdx2 <= size - 1 && store[childIdx2] < store[minIndex]) {
                minIndex = childIdx2;
            }

            return minIndex;
        }

        private void heapifyUp(int index) {
            if(index == 0) {
                return;
            }
            int parentIdx = (index - 1)/2 ;
            if(store[index] >= store[parentIdx]) {
                return;
            }

            //swap idx nad parentIndex values
            swapArrayValues(index, parentIdx);
            heapifyUp(parentIdx);
        }

        private void swapArrayValues(int idx1, int idx2) {
            int temp = store[idx1];
            store[idx1] = store[idx2];
            store[idx2] = temp;
        }

    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(7);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(8);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(9);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
    }

}
