package com.p2.slidiing.window.fixed;

import java.util.*;

//Good Question
/**
 * Monotonic DeQueue : At any state the elements in queue are in decreasing order , that's why called monotonic
 *
 * WHY DeQueue :
 *      Let's say window x[3, 2, 1]y , incoming element is 4, remove both 3 then 2 then 1 from x-end of DeQueue until queue is empty and add 4
 *      Let's say window x[3, 1, 0]y , incoming element is 2, remove both 0 then 1 from y-end of DeQueue until larger element is met
 *      So we need a Doubly Ended Queue
 *
 * Note: Dequeue stores indices, not actual numbers
 */
public class SlidingWindowMaximum239 {

    public int[] maxSlidingWindow(int[] nums, int windowSize) {
        int left = 0;
        int right = 0;

        Deque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[nums.length - windowSize + 1];
        int resultCount = 0;

        while (right < nums.length) {
            int rightPointerElem = nums[right];

            if(right - left + 1 < windowSize) {
                //Handle Right Ptr Start
                if(!queue.isEmpty() && nums[queue.peekFirst()] < rightPointerElem) {//If incoming number is bigger than queue 1st element, pop queue elements until empty from queue-first
                    while (!queue.isEmpty()) {
                        queue.removeFirst();
                    }
                } else if(!queue.isEmpty() && nums[queue.peekLast()] < rightPointerElem) {//If incoming number is bigger than queue last element, pop queue elements bigger number is met from queue-last
                    while (!queue.isEmpty() && nums[queue.peekLast()] < rightPointerElem) {
                        queue.removeLast();
                    }
                }
                queue.addLast(right);
                right++;
                //Handle Right Ptr End
            } else if(right - left + 1 == windowSize) {
                //Handle Right Ptr, Note copy of if clause logic
                if(!queue.isEmpty() && nums[queue.peekFirst()] < rightPointerElem) {
                    while (!queue.isEmpty()) {
                        queue.removeFirst();
                    }
                } else if(!queue.isEmpty() && nums[queue.peekLast()] < rightPointerElem) {
                    while (!queue.isEmpty() && nums[queue.peekLast()] < rightPointerElem) {
                        queue.removeLast();
                    }
                }
                queue.addLast(right);
                right++;
                //Handle Right Ptr End

                result[resultCount++] = nums[queue.peekFirst()];

                //Handle Left Pointer
                if(!queue.isEmpty() && queue.peekFirst() == left) {
                    queue.removeFirst();
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SlidingWindowMaximum239().maxSlidingWindow(new int[]{1,2,3,-1,2,4, 2, 5}, 3)));
    }
}
