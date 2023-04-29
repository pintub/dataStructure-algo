package year2k21.common.pattern.general.two.pointer.date17042023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> traversedNumVsIndex = new HashMap<>();

        for(int idx = 0; idx < nums.length; idx++) {
            int temp = target - nums[idx];
            if(traversedNumVsIndex.containsKey(temp)) {
                return new int[]{traversedNumVsIndex.get(temp), idx};
            }

            traversedNumVsIndex.put(nums[idx], idx);
        }

        System.out.println("WHOAA!! How you found me!!");
        return null;
    }

    public static void main(String[] args) {
        TwoSum1 sol = new TwoSum1();
        System.out.println(Arrays.toString(sol.twoSum(new int[]{2,7,11,15}, 9)));//[0,1]
        System.out.println(Arrays.toString(sol.twoSum(new int[]{3,2,4}, 6)));//[2,1]
        System.out.println(Arrays.toString(sol.twoSum(new int[]{3,3}, 6)));//[0,1]
    }
}
