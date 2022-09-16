package year2k21.common.pattern.general.two.pointer;

import java.util.*;

/**
 * Repeat {@link year2k21.common.pattern.sorting.SortColors75}
 */
public class SortColors75 {
    public void sortColors(int[] nums) {
        int lowIdx = 0;//Keeps track of latest available place for "0" color from left
        int hiIdx = nums.length - 1;//Keeps track of latest available place for "2" color from right

        int midIdx = 0;
        while (midIdx <= hiIdx) {
            if(nums[midIdx] == 1) {
                ++midIdx;
            } else if(nums[midIdx] == 2) {
                swap(nums, midIdx, hiIdx);
                --hiIdx;
            } else {
                swap(nums, midIdx, lowIdx);
                ++lowIdx;
                if(lowIdx >= midIdx)
                    midIdx = lowIdx;
            }
        }
    }

    static void swap(int[] array, int i, int j){
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        new SortColors75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
