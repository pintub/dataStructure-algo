package year2k21.common.pattern.recursionANDbacktracking.date12042023;

import java.util.ArrayList;
import java.util.List;

/**
 * Print Target Sum , BackTracking Better Than DP w/ Memo
 */
public class CombinationSum39 {

    public List<List<Integer>> combinationSum_backtracking(int[] candidates, int target) {
        List<List<Integer>> result  = new ArrayList<>();

        recursion(candidates, candidates.length, target, result, new ArrayList<>());

        return result;
    }

    private void recursion(final int[] candidates, int index, int target, List<List<Integer>> result, List<Integer> prefix) {
        if(target == 0) {
            if(!prefix.isEmpty())
                result.add(new ArrayList<>(prefix));
            return;
        }

        if(index == 0) {
            return;
        }

        //Including current Element
        if(target - candidates[index - 1] >= 0) {
            prefix.add(candidates[index - 1]);
            recursion(candidates, index, target - candidates[index - 1], result, prefix);
            prefix.remove(prefix.size() - 1);
        }

        //Excluding current Element
        recursion(candidates, index - 1, target, result, prefix);
    }

    public List<List<Integer>> combinationSum_dp(int[] candidates, int target) {
        List<List<Integer>>[] memo = new ArrayList[target + 1];
        for (int candidateIndex = 0; candidateIndex <= candidates.length; candidateIndex++) {
            for (int targetIndex = 0; targetIndex <= target; targetIndex++) {
                if (targetIndex == 0) {
                    List<List<Integer>> temp = new ArrayList<>();
                    temp.add(new ArrayList<>());
                    memo[targetIndex] = temp;
                    continue;
                }
                if(candidateIndex == 0) {
                    memo[targetIndex] = new ArrayList<>();
                    continue;
                }

                List<List<Integer>> newList = new ArrayList<>();
                //Including current Element
                if(targetIndex - candidates[candidateIndex - 1] >= 0) {
                    List<List<Integer>> temp =memo[targetIndex - candidates[candidateIndex - 1]];
                    if(!temp.isEmpty()) {
                        for(List<Integer> list : temp) {
                            List<Integer> listCopy = new ArrayList<>(list);
                            listCopy.add(candidates[candidateIndex - 1]);
                            newList.add(listCopy);
                        }
                    }
                }

                //Excluding current Element
                List<List<Integer>> temp = new ArrayList<>(memo[targetIndex]);
                if(!temp.isEmpty()) {
                    for(List<Integer> list : temp) {
                        List<Integer> listCopy = new ArrayList<>(list);
                        newList.add(listCopy);
                    }
                }
                memo[targetIndex] = newList;
            }
        }

        return memo[target];
    }

    public static void main(String[] args) {
        CombinationSum39 sol = new CombinationSum39();
        //System.out.println(sol.combinationSum_backtracking(new int[]{2,3,6,7}, 7));
        System.out.println(sol.combinationSum_backtracking(new int[]{2,3,5}, 8));
        //System.out.println(sol.combinationSum_backtracking(new int[]{2}, 1));
    }
}
