package year2k21.common.pattern.binaryoperation.xor;

//BUT HOW??
//Need to Remember, but mathematical solution is also O(n)
public class MissingNumber268 {

    int missingNumber(int[] nums) {
        int answer = 0;
        for(int i = 0; i < nums.length; ++i) {
            answer ^= i; //Index
            answer ^= nums[i]; //Actual Number
        }
        return answer ^ nums.length;
    }
}
