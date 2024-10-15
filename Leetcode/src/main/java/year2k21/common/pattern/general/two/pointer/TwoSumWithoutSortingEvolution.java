package year2k21.common.pattern.general.two.pointer;

import java.util.HashMap;
import java.util.Map;

/**
 * One type solution for Two sum is sorting array & using 2-pointers.
 *
 * Below context is not using sorting , rather using HashMap
 */
public class TwoSumWithoutSortingEvolution {

    /**
     * 2 pass using HashMap
     *
     * Assume : No Dups
     */
    public int[] twoSum_DoublePass(int[] nums, final int target) {
        Map<Integer, Integer> numVsIndex = new HashMap<>();
        for(int index = 0; index < nums.length; index++) {
            numVsIndex.put(nums[index], index);
        }

        for(int index = 0; index < nums.length; index++) {
            int otherElem = target - nums[index];
            if(numVsIndex.get(otherElem) != null
                    && numVsIndex.get(otherElem) != index) {//Notice this, same value of an index should not be used twice
                return new int[]{index, numVsIndex.get(otherElem)};
            }
        }

        return null;//No pair found
    }

    /**
     * Evolve above solution to Single pass using HashMap
     *
     * NOTE: For every elem, check if other potential elem has already existed in the past
     *
     * Assume : No Dups
     */
    public int[] twoSum_SinglePass(int[] nums, final int target) {
        Map<Integer, Integer> numVsIndex = new HashMap<>();

        for(int index = 0; index < nums.length; index++) {
            int otherElem = target - nums[index];
            if(numVsIndex.get(otherElem) != null) {
                return new int[]{index, numVsIndex.get(otherElem)};
            }
            numVsIndex.put(nums[index], index);
        }

        return null;//No pair found
    }

    /**
     * Evolve above Single pass solution to 3 sum HashMap
     *
     * NOTE: Fix 1st elem, then for remaining array, try 2-sum
     *
     * Assume : No Dups
     */
    public int[] threeSum_SinglePass(int[] nums, final int target) {
        for(int i = 0; i < nums.length - 1; i++) {//Note, Fixing 1st elem

            int newTarget = target - nums[i];

            //Below is 2-sum solution using newTarget as target
            Map<Integer, Integer> numVsIndex = new HashMap<>();

            for(int j = 0; j < nums.length; j++) {
                int otherElem = newTarget - nums[j];
                if (numVsIndex.get(otherElem) != null) {
                    return new int[]{i, j , numVsIndex.get(otherElem)};
                }
                numVsIndex.put(nums[j] , j);
            }
        }

        return null;//No pair found
    }

    /**
     * Evolve above Single pass 3-sum problem
     *
     * (a + b + c)%d = 0
     * => a % d + b % d + c % d = d
     * => b % d + c % d = d - a % d
     *  => b % d = d - ( a%d + b%d)
     *
     */
    public int[] tripletDivisibleByD(int[] nums, final int d) {
        for(int i = 0; i < nums.length - 1; i++) {//Note, Fixing 1st elem

            int newTarget = d - (nums[i] % d);

            //Below is 2-sum solution using newTarget as target
            Map<Integer, Integer> numVsIndex = new HashMap<>();

            for(int j = 0; j < nums.length; j++) {
                int otherElem = newTarget - (nums[j] % d);
                if (numVsIndex.get(otherElem) != null) {
                    return new int[]{i, j , numVsIndex.get(otherElem)};
                }
                numVsIndex.put(nums[j] % d , j);
            }
        }

        return null;//No pair found
    }
}
