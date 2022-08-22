package year2k21.common.pattern.binary;

/**
 * Couldn't solve
 *
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * Intuition:
 *      Basically same numbers should nullify each other, how to achieve, Here comes XOR
 *      If you XOR all numbers, finalXOR = singleNum1 XOR singleNum2
 *
 *      In finalXOR , there would be 1' where singleNum1, singleNum2 has different value at same positions, Assume that position is "X"
 *          Partition nums into array1(containing 0 at position "X") and array2(containing 1 at position "X")
 *          XOR of array1 -> Gives one singleNum1
 *          XOR of array2 -> Gives other singleNum1
 *
 * Explanation:
 *      https://leetcode.com/problems/single-number-iii/discuss/68901/Sharing-explanation-of-the-solution
 *      https://leetcode.com/problems/single-number-iii/discuss/68901/Sharing-explanation-of-the-solution/263808
 */
public class SingleNumberIII260 {

    public int[] singleNumber(int[] nums) {

        int singleNum1 = 0, singleNum2 = 0;

        int finalXOR = 0;
        //Find Final XOR
        for(int num : nums) {
            finalXOR = finalXOR ^ num;
        }

        //Find where is last 1-Bit and create a mask
        int mask = finalXOR & -finalXOR;//Only last 1-Bit will be 1 and others become 0


        for(int num : nums) {
            if((mask & num) != 0) {//1 is present
                singleNum1 = singleNum1 ^ num;
            } else {
                singleNum2 = singleNum2 ^ num;
            }
        }

        return new int[] {singleNum1, singleNum2};
    }
}
