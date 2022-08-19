package year2k21.common.pattern;

/**
 * Similar to {@link year2k21.common.pattern.MaximumSubArray53} Product instead of Sum in Question
 *
 * Question is similar, answer is not
 *
 * https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity/248020
 * I didn't solve, Had to quit :(
 */
public class MaximumProductSubArray152 {

    public int maxProduct(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumProductSubArray152().maxProduct(new int[]{2, 0, 1}) == 2);
        System.out.println(new MaximumProductSubArray152().maxProduct(new int[]{0, 1, 3}) == 3);
        System.out.println(new MaximumProductSubArray152().maxProduct(new int[]{-2, 0, -1}) == 0);
        System.out.println(new MaximumProductSubArray152().maxProduct(new int[]{2,3,-2,4}) == 6);
    }
}
