package year2k21.common.pattern.recursionANDbacktracking.date12042023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsDuplicateII47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        permuteUnique(0, new ArrayList<>(), nums, result);
        return result;
    }

    void permuteUnique(int pos, List<Integer> prefix, int[] nums, List<List<Integer>> result) {
        if(pos == nums.length) {
            result.add(new ArrayList<>(prefix));
            return;
        }

        for(int idx = 0; idx <= nums.length - 1; idx++) {
            if(idx != 0 && nums[idx] == nums[idx - 1]) {//While picking from candidates, process 1st one, then Skip dups (Note we squeezed removing dups in Divide and Conquer one-directional)
                continue;
            }
            if(nums[idx] == -100)
                continue;

            int num = nums[idx];
            prefix.add(num);
            nums[idx] = -100;

            permuteUnique(pos + 1, prefix, nums, result);

            prefix.remove(prefix.size() - 1);
            nums[idx] = num;
        }
    }

    public static void main(String[] args) {
        PermutationsDuplicateII47 sol = new PermutationsDuplicateII47();
        System.out.println(sol.permuteUnique(new int[]{1,2,3}));
        System.out.println(sol.getBinaryInt("ca"));
    }

    private int getBinaryInt(String str) {
        int result = 0;
        for(char c : str.toCharArray()) {
            result = result | (1 << c - 65);
        }

        return result;
    }
}
