package year2k21.common.pattern.dp.date21022023;

//Space-optimized version

/**
 * 2 variables ,compared to 1 var of MaxSumArray
 * 1st to store max till last Index, 2nd to store Min(To handle -v *-ve ) scenario
 */
public class MaximumProductSubarray152 {

    int result = -1;
    public int maxProduct(int[] nums) {
        result = nums[0];

        int maxTillLastIndex = nums[0];
        int minTillLastIndex = nums[0];

        for (int i=1; i<= nums.length-1; i++) {
            int tempMax = Math.max(maxTillLastIndex * nums[i], nums[i]);
            tempMax = Math.max(minTillLastIndex * nums[i], tempMax);

            int tempMin = Math.min(maxTillLastIndex * nums[i], nums[i]);
            tempMin = Math.min(minTillLastIndex * nums[i], tempMin);

            result = Math.max(result, tempMax);
            maxTillLastIndex = tempMax;
            minTillLastIndex = tempMin;
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumProductSubarray152 sol = new MaximumProductSubarray152();
        //System.out.println(sol.maxProduct(new int[]{-2, 3, -4}) == 24);
        //System.out.println(sol.maxProduct(new int[]{-2, 3, 4}) == 12);
        System.out.println(sol.maxProduct(new int[]{2,-5,-2,-4,3}) == 24);
        //System.out.println(sol.maxProduct(new int[]{-2,0,-1}) == 0);
    }
}
