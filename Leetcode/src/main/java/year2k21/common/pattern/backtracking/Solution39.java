package year2k21.common.pattern.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();

        //recursion_deprecated(output, candidates, target, new ArrayList<>());
        recursion(output, candidates, candidates.length-1, target, new ArrayList<>());

        return output;
    }

    private void recursion(List<List<Integer>> output, int[] candidates, int index, int target,
                           List<Integer> prefix) {
        if(target < 0 || index < 0) {
            return;
        }

        if(target == 0) {//At the leaf node, prepare output
            output.add(new ArrayList<>(prefix));
            return;
        }

        int currentElem = candidates[index];
        prefix.add(currentElem);
        recursion(output, candidates, index, target - currentElem, prefix);//Include indexth element, dont
        // decrease array
        prefix.remove(Integer.valueOf(currentElem));
        recursion(output, candidates, index-1, target, prefix);//Exclude indexth element
    }

    @Deprecated
    private void recursion_deprecated(List<List<Integer>> output, int[] candidates, int target, List<Integer> prefix) {
        if(target < 0) {
            return;
        }

        if(target == 0) {//At the leaf node, prepare output
            Collections.sort(prefix);
            if(!output.contains(prefix)) {
                output.add(prefix);
            }
            return;
        }

        for(int candidate : candidates) {
            List<Integer> temp = new ArrayList<>(prefix);
            temp.add(candidate);
            recursion_deprecated(output, candidates, target - candidate, temp);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution39().combinationSum(new int[]{3,5,2}, 8));
    }
}
