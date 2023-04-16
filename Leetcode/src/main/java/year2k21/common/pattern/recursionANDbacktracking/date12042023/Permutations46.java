package year2k21.common.pattern.recursionANDbacktracking.date12042023;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        recursion(0, nums, result, new ArrayList<>());

        return result;
    }

    private void recursion(int pos, int[] nums, List<List<Integer>> result, ArrayList<Integer> prefix) {
        if(pos == nums.length)
            result.add(new ArrayList<>(prefix));

        for(int count = 0; count < nums.length; count++) {
            if(nums[count] == Integer.MIN_VALUE)
                continue;
            int temp = nums[count];
            prefix.add(nums[count]);
            nums[count] = Integer.MIN_VALUE;

            recursion(pos + 1, nums, result, prefix);

            nums[count] = temp;
            prefix.remove(prefix.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations46 sol = new Permutations46();
        System.out.println(sol.permute(new int[]{1,2,3}));//[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
        System.out.println(sol.permute(new int[]{1,2}));//[[1, 2], [2, 1]]
        System.out.println(sol.permute(new int[]{1}));//[[1]]
    }
}
