package year2k21.common.pattern.recursionANDbacktracking.date12042023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Time = 2^n subsets found, thus 2^n
 * Space = 2^n (#subsets) * n(Each subset of length n) + O(n) Recursion space
 */
public class SubsetsDuplicateII90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        recursion(0, nums, new ArrayList<Integer>(), res);
        return res;
    }

    /**
     * If Excluding, then we will not add all the following same element, just jump to the index where nums[index] is a different value
     * If Including, Nothing Special
     *
     * basically include all or exclude all
     */
    public void recursion(int index, int[] nums, List<Integer> cur, List<List<Integer>> res){
        if(index == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        // If Including
        cur.add(nums[index]);
        recursion(index + 1, nums, cur, res);
        cur.remove(cur.size() - 1);

        // If Excluding, then we will not add all the following same element, just jump to the index where nums[index] is a different value . Basically Include All or exclude all
        int i = index;
        while(i < nums.length && nums[i] == nums[index]) i++;
        recursion(i, nums, cur, res);//New Index is used
    }


    /**
     * Using Take-NoTake approach , & additional "hashSet" to store result
     * Thus not-optimized
     */
    public List<List<Integer>> subsetsWithDupWithHashSet(int[] nums) {
        //Arrays.sort(nums);//not required if using Set

        Set<List<Integer>> result = new HashSet<>();
        result.add(new ArrayList<>());

        recursionWithHashSet(nums, 0, result, new ArrayList<>());

        return new ArrayList<>(result);
    }

    private void recursionWithHashSet(int[] nums, int index, Set<List<Integer>> result, ArrayList<Integer> prefix) {
        if(index == nums.length) {
            return;
        }

        int currentElem = nums[index];
        //Including current Elem
        prefix.add(currentElem);
        result.add(new ArrayList<>(prefix));
        recursionWithHashSet(nums, index + 1, result, prefix);
        prefix.remove(prefix.size() - 1);

        //Excluding current Elem
        recursionWithHashSet(nums, index + 1, result, prefix);
    }

    public static void main(String[] args) {
        SubsetsDuplicateII90 sol = new SubsetsDuplicateII90();
        System.out.println(sol.subsetsWithDup(new int[]{1,2,2,4}));//[[], [1], [1, 2], [1, 2, 2], [1, 2, 2, 4], [1, 2, 4], [1, 4], [2], [2, 2], [2, 2, 4], [2, 4], [4]]
        System.out.println(sol.subsetsWithDup(new int[]{1,2,2}));//[[], [2], [2, 2], [1], [1, 2], [1, 2, 2]]

        //System.out.println(sol.subsetsWithDup(new int[]{1}));//[[1],[]
    }
}
