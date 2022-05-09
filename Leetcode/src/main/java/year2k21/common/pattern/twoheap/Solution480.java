package year2k21.common.pattern.twoheap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution480 {

    static class MedianFinder {

        private Queue<Integer> minHeap;
        private Queue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
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
                maxHeap.add(minHeap.poll());
            }
        }

        //O(n) for contains() + re-balance
        public void deleteNum(int num) {
            if(maxHeap.contains(num)) {
                maxHeap.remove(num);
            } else {
                minHeap.remove(num);
            }

            if(minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            } else if(maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            if(maxHeap.size() - minHeap.size() == 1) {
                return maxHeap.peek();
            }

            return ((long)maxHeap.peek() + (long)minHeap.peek()) / 2.0;
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        MedianFinder medianFinder = new MedianFinder();
        int left = 0;
        int right = 0;
        double[] medians = new double[nums.length - k + 1];
        int medianCount = 0;
        while (right <= nums.length - 1) {
            if (right + 1 - left < k) {//Till 1st window made
                medianFinder.addNum(nums[right]);
                right++;
                continue;
            }
            //Now window size(r+1-l) is k, find Median , increment left and right
            medianFinder.addNum(nums[right]);
            medians[medianCount++] = medianFinder.findMedian();
            medianFinder.deleteNum(nums[left]);
            ++left;
            ++right;
        }


        return medians;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution480().medianSlidingWindow(new int[]{1,2,3,4,2,3,1,4,2}, 3)));
    }
}
