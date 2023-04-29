package year2k21.common.pattern.general.two.pointer.date17042023;

import java.util.Arrays;

public class ThreeSumClosest16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closetDifference = Integer.MAX_VALUE;//threeSum - target

        for(int count = 0; count < nums.length - 2; count++) {//Notice this, Used same concept as ThreeSum
            int low = count + 1;
            int high = nums.length - 1;
            while (low < high) {
                int threeSum = nums[count] + nums[low] + nums[high];
                if (threeSum == target) {
                    return target;
                }
                if (threeSum < target) {
                    closetDifference = Math.abs(closetDifference) <= Math.abs(threeSum - target) ? closetDifference : threeSum - target;
                    ++low;
                } else {
                    closetDifference = Math.abs(closetDifference) <= Math.abs(threeSum - target) ? closetDifference : threeSum - target;
                    --high;
                }
            }
        }
        return target + closetDifference;
    }

    public static void main(String[] args) {
        ThreeSumClosest16 sol = new ThreeSumClosest16();
        System.out.println(sol.threeSumClosest(new int[]{-1,2,1,-4}, 1));//2
        System.out.println(sol.threeSumClosest(new int[]{0,0,0}, 1));//0
    }
}
