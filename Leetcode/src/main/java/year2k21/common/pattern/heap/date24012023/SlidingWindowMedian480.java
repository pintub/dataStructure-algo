package year2k21.common.pattern.heap.date24012023;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMedian480 {

    private final Queue<Integer> minHeap = new PriorityQueue<>();
    private final Queue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));

    //O(n)
    public double[] medianSlidingWindow(int[] nums, int k) {
        int left = 0, right = 0;
        int len = nums.length;
        double[] result = new double[len - k + 1];
        int resultCount = 0;
        while(right < len) {
            if(right - left < k-1) {//Less than window size
                addNum(nums[right]);
                right++;
            } else if(right - left == k-1) {//Window reached and further maintained
                remove(nums, left - 1);
                addNum(nums[right]);
                result[resultCount] = getMedian();
                resultCount++;
                left++;
                right++;
            }
        }

        return result;
    }

    //O(n)
    private void remove(int[] nums, int index) {
        if(index < 0) {
            return;
        }
        int num = nums[index];
        if((double) num <= maxHeap.peek()) {
            maxHeap.remove(num);
        } else  {
            minHeap.remove(num);
        }
    }

    /**
     * O(2nlogk)
     */
    void addNum(int num) {
        if(minHeap.size() >= maxHeap.size()) {
            minHeap.add(num);
            maxHeap.add(minHeap.remove());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.remove());
        }
    }

    double getMedian() {
        return maxHeap.size() == minHeap.size() ? ((double) maxHeap.peek() + (double) minHeap.peek())/2 : maxHeap.size() > minHeap.size() ? (double) maxHeap.peek() : (double) minHeap.peek();
    }

    public static void main(String[] args) {
        SlidingWindowMedian480 sol = new SlidingWindowMedian480();
        System.out.println(Arrays.toString(sol.medianSlidingWindow(new int[]{2147483647,1,2,3,4,5,6,7,2147483647}, 2)));
    }
}
