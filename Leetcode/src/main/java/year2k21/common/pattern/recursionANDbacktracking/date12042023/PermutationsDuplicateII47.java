package year2k21.common.pattern.recursionANDbacktracking.date12042023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1st You got to sort
 */
public class PermutationsDuplicateII47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); //Sorting is Required
        permuteUnique(new ArrayList<>(), nums, result);
        return result;
    }

    void permuteUnique(List<Integer> prefix, int[] nums, List<List<Integer>> result) {
        if(prefix.size() == nums.length) {
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

            permuteUnique(prefix, nums, result);

            prefix.remove(prefix.size() - 1);
            nums[idx] = num;
        }
    }

    public static void main(String[] args) {
        PermutationsDuplicateII47 sol = new PermutationsDuplicateII47();
        System.out.println(sol.permuteUnique(new int[]{1,2,3}));//[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
        System.out.println(sol.permuteUnique(new int[]{1,1,2}));//[[1, 1, 2], [1, 2, 1], [2, 1, 1]]
    }

}
