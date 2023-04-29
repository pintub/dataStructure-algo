package year2k21.common.pattern.general.two.pointer.date17042023;

import java.util.Arrays;

public class SortColors75 {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = low;

        while (mid <= high) {
            if(nums[mid] == 1) {
                mid++;
            }else if(nums[mid] == 0){
                swap(low, mid, nums);
                low++;
                if(low >= mid)
                    mid = low;
            } else {
                swap(high, mid, nums);
                high--;
            }
        }
    }

    static void swap(int i, int j, int[] array){
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

    public void sortColors_UsingCountSorting(int[] nums) {
        int count[] = new int[3];
        for(int num : nums) {
            ++count[num];
        }

        for(int idx = 1; idx < count.length; idx++) {
            count[idx] = count[idx] + count[idx - 1];
        }

        /*for(int idx = 0; idx < count.length; idx++) {
            count[idx] = --count[idx];
        }*/
        int[] output = new int[nums.length];
        for(int high = nums.length - 1; high >=0; high--) {
            output[--count[nums[high]]] = nums[high];
        }

        for(int high = nums.length - 1; high >=0; high--) {
            nums[high] = output[high];
        }
    }

    public static void main(String[] args) {
        SortColors75 sol = new SortColors75();
        //int[] nums = {2, 0, 2, 1, 1, 0};//[0, 0, 1, 1, 2, 2]
        int[] nums = {2, 0, 1};//[0, 1, 2]
        sol.sortColors_UsingCountSorting(nums);
        System.out.println(Arrays.toString(nums));
    }

}
