package year2k21.common.pattern.general;

import java.util.Arrays;

public class ProductOfArrayExceptSelf238 {

    /**
     * result[i] = result[0..i-1] * result[i+1..arrLen]
     *
     * So, need always product[0..someIndex] & product[someIndex..y]
     * Maintain 2 array cumulativeProductLeftToRight[] & cumulativeProductRightToLeft[]
     * Time = O(3n) & Space=O(2n)
     *
     * Improve space complexity:
     *          Store cumulativeProductLeftToRight[] in result[]
     *          While Calculating cumu product right to left, you need only one variable and fill update result[] right to left
     *
     *
     * READ last optimized solution:
     *          https://leetcode.com/problems/product-of-array-except-self/solutions/1342916/3-minute-read-mimicking-an-interview/?envType=study-plan-v2&envId=top-interview-150
     */
    public int[] productExceptSelf(int[] nums) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf238().productExceptSelf(new int[]{-1,1,0,-3,3})));
    }
}
