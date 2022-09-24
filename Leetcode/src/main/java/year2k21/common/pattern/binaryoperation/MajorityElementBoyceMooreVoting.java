package year2k21.common.pattern.binaryoperation;

//WHAT-THE-HECK

/**
 * Alternative readable solution {@link year2k21.common.pattern.sorting.MajorityElementBoyceMooreVoting169}
 */
public class MajorityElementBoyceMooreVoting {

    int majorityElement(int[] nums) {

        int len = 4 * 8, size = nums.length; //4 is int bytes in Java

        int count = 0, mask = 1, ans = 0;

        for(int i = 0; i < len; ++i) {
            count = 0;
            for(int j = 0; j < size; ++j)
                if((mask & nums[j]) != 0)
                    count++;
            if(count > size/2)
                ans |= mask;
            mask <<= 1;
        }
        return ans;
    }
}
