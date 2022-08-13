package year2k21.common.pattern.sorting;

import java.util.*;

/**
 * Sorting problem to use in-place sorting & O(n)
 * Solution1:
 *  Using quick sort is not enough :(
 * Solution2:
 * Use can use counting sorting, as count[] size will be 3 as only 3 colors, but time = O(2n)
 * Solution3:
 *  Dutch Flag problem, Dutch flag has 3 colors
 *  Keep red color(1) at start of array, blue(2) at end, and white(1) at middle
 */
public class SortColors75 {
    public void sortColors(int[] nums) {
        //quickSort(nums, 0, nums.length - 1);
        int redIdx = 0;
        int blueIdx = nums.length - 1;
        int middleIdx = 0;
        while(middleIdx <= blueIdx){
            if(nums[middleIdx] == 0){
                swap(nums, redIdx, middleIdx);
                ++redIdx;
                ++middleIdx;
            } else if(nums[middleIdx] == 2){
                swap(nums, middleIdx, blueIdx);
                --blueIdx; //WHY middleIdx not increased here, cause while swapping midIdx may get 2
            } else {
                ++middleIdx;
            }
        }
    }

    private void quickSort(int[] nums, int loIdx, int hiIdx) {
        if(hiIdx < loIdx) {
            return;
        }
        int partitionIdx = partition(nums, loIdx, hiIdx);
        quickSort(nums, loIdx, partitionIdx - 1);
        quickSort(nums,partitionIdx + 1, hiIdx);
    }

    private int partition(int[] nums, int loIdx, int hiIdx) {
        int i = loIdx;
        for(int j=loIdx; j<hiIdx; j++) {
            if (nums[j] <= nums[hiIdx]) {
                if(i != j) {
                    swap(nums, i, j);
                }
                ++i;
            }
        }

        swap(nums, i, hiIdx);

        return i;
    }

    static void swap(int[] array, int i, int j){
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

    public static void main(String[] args) {
        int[] colors = {2, 0, 2, 1, 1, 0};
        new SortColors75().sortColors(colors);

        System.out.println(Arrays.toString(colors));
    }
}
