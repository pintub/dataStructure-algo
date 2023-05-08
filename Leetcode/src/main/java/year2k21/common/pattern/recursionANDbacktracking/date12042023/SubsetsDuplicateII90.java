package year2k21.common.pattern.recursionANDbacktracking.date12042023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsDuplicateII90 {

    /**
     * Time = 2^n subsets found, thus 2^n
     * Space = 2^n (#subsets) * n(Each subset of length n) + O(n) Recursion space
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);//Sort Array

        List<List<Integer>> result = new ArrayList<>();

        recursion(nums, 0, result, new ArrayList<>());

        return result;
    }

    private void recursion(int[] nums, int index, List<List<Integer>> result, ArrayList<Integer> prefix) {
        result.add(new ArrayList<>(prefix));

        for(int i = index; i < nums.length; i++) {//Notice this, 1st level of Recursion Tree generates subset of size=1, 2nd level of size=2 , and so on
            if(i != index && nums[i] == nums[i - 1])
                continue;

            prefix.add(nums[index]);
            recursion(nums, i + 1, result, prefix);
            prefix.remove(prefix.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDupV2(int[] nums) {
        Arrays.sort(nums);//Sort Array

        Set<List<Integer>> result = new HashSet<>();
        result.add(new ArrayList<>());

        recursionV2(nums, 0, result, new ArrayList<>());

        return new ArrayList<>(result);
    }

    private void recursionV2(int[] nums, int index, Set<List<Integer>> result, ArrayList<Integer> prefix) {
        if(index == nums.length) {
            return;
        }

        int currentElem = nums[index];
        //Including current Elem
        prefix.add(currentElem);
        result.add(new ArrayList<>(prefix));
        recursionV2(nums, index + 1, result, prefix);
        prefix.remove(prefix.size() - 1);

        //Excluding current Elem
        recursionV2(nums, index + 1, result, prefix);
    }

    public static void main(String[] args) {
        SubsetsDuplicateII90 sol = new SubsetsDuplicateII90();
        System.out.println(sol.subsetsWithDup(new int[]{1,2,2}));//[[1], [1, 2, 2], [], [2], [2, 2], [1, 2]]
        System.out.println(sol.subsetsWithDup(new int[]{1}));//[[1],[]
    }
}
