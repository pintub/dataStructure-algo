package year2k21.common.pattern.dp.date21022023;

import java.util.Arrays;

public class JumpGame55 {

    /**
     * Read DP.md
     *
     */
    public boolean canJump(int[] nums) {
        int maxReachable = 0, len = nums.length;
        for (int i = 0; i < len & i <= maxReachable; i++) {//Why i <= maxReachable, if i > maxReachable , means maxReachable position crossed & from there you are not able to move ahead
            maxReachable = Math.max(maxReachable, i + nums[i]);
            if (maxReachable >= len - 1) return true;   // terminate loop early to speed up
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame55 sol = new JumpGame55();
        //All answers should be TRUE
        System.out.println(sol.canJump(new int[]{2,3,1,1,4}));
        System.out.println(sol.canJump(new int[]{3,2,1,0,4}) == false);
        System.out.println(sol.canJump(new int[]{7,2,1,0,4}));
    }

    public boolean canJump_myVersion(int[] nums) {
        int[] memo = new int[nums.length];//1 means true, 0 means false
        Arrays.fill(memo, -1);

        return canJump(0, nums, memo);
    }

    private boolean canJump(int index, int[] nums, int[] memo) {
        if(memo[index] != -1){
            return memo[index] == 1 ? true : false;
        }
        if(index == nums.length - 1) {
            memo[index] = 1;
            return true;
        }

        int num = nums[index];
        if(num == 0) {
            memo[index] = 0;
            return false;
        }

        for (int count = 1; count <= num; count++) {
            if(!(index + count > nums.length - 1) && canJump(index + count, nums, memo)) {
                memo[index] = 1;
                return true;
            }
        }
        memo[index] = 0;
        return false;
    }

}
