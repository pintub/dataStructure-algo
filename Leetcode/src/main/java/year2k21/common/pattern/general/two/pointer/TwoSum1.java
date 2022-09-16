package year2k21.common.pattern.general.two.pointer;

import java.util.*;

/**
 * Approach 1 :
 *          Sorted Array, & traverse using 2 pointers from both sides . Time = O(nlogn) + O(n) = O(nlogn), space = O(1)
 *  Approach 2 :
 *          HashMap to keep numberVsIndex, Go left to Right. Time = O(n), space = O(n)
 */
public class TwoSum1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numVsIndex = new HashMap<>();

        for(int index = 0; index < nums.length; index++) {
            if (numVsIndex.containsKey(target - nums[index])) {
                int otherIndex = numVsIndex.get(target - nums[index]);
                return new int[]{index, otherIndex};
            }
            numVsIndex.put(nums[index], index);
        }

        System.out.println("You can't reach me!!!");
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum1().twoSum(new int[]{2,7,11,15}, 9)));
    }
}
