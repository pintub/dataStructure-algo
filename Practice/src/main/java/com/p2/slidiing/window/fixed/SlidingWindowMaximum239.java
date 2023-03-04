package com.p2.slidiing.window.fixed;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//Good Question
/**
 * Monotonic DeQueue : At any state the elements in queue are in decreasing order , that's why called monotonic
 *
 * WHY DeQueue :
 *   y-end:
 *     Let's say DeQ x[3, 2, 1]y , incoming element is 4, remove both 1 then 2 then 3 from "y-end" of DeQueue until larger element is met and add 4
 *     Let's say DeQ x[3, 1, 0]y , incoming element is 2, remove both 0 then 1 from "y-end" of DeQueue until larger element is met
 *   x-end:
 *     When you peek for largest element to update result, or to remove the DeQ element if out of window
 *
 * Note: Dequeue stores indices, not actual numbers
 */
public class SlidingWindowMaximum239 {

    public int[] maxSlidingWindow(int[] nums, int windowSize) {
        int left = 0;
        int right = 0;

        Deque<Integer> queue = new ArrayDeque<>();
        //Memorization
        int[] result = new int[nums.length - windowSize + 1];
        //Result
        int resultCount = 0;

        while (right < nums.length) {
            int rightPointerElem = nums[right];

            if(right - left + 1 < windowSize) {
                if(!queue.isEmpty() && nums[queue.peekLast()] < rightPointerElem) {//If incoming number is bigger than queue last element, pop queue elements until bigger number is met from queue-last
                    while (!queue.isEmpty() && nums[queue.peekLast()] < rightPointerElem) {
                        queue.removeLast();
                    }
                }
                queue.addLast(right);
                right++;
            } else if(right - left + 1 == windowSize) {
                //Note copy of if clause logic
                if(!queue.isEmpty() && nums[queue.peekLast()] < rightPointerElem) {
                    while (!queue.isEmpty() && nums[queue.peekLast()] < rightPointerElem) {
                        queue.removeLast();
                    }
                }
                queue.addLast(right);
                right++;

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
        System.out.println(Arrays.toString(new SlidingWindowMaximum239().maxSlidingWindow(new int[]{1,2,3,-1,2,4, 2, 5}, 3)));//[3, 3, 3, 4, 4, 5]
        System.out.println(Arrays.toString(new SlidingWindowMaximum239().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));//[3, 3,3,5,5,6,7]
        System.out.println(Arrays.toString(new SlidingWindowMaximum239().maxSlidingWindow(new int[]{1}, 1)));//[1]
    }
}
