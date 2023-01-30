package year2k21.common.pattern.tree.date18012023;

import java.util.HashMap;
import java.util.Map;

/**
 * Traverse each node
 *      At each node check targetSum using countTargetSum() by traversing down
*   So, O(n^2)
 *
 * Another Approach:
 *   O(n) using backtracking, Check pathSum_BackTracking()
*
 */
public class PathSumIII437 {

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;

        return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + countTargetSum(root, targetSum);
    }

    private int countTargetSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }

        int result = 0;

        if(targetSum == root.val) { //Notice this , Not targetSum == 0
            ++result;
        }

        result += countTargetSum(root.left, targetSum - root.val);
        result += countTargetSum(root.right, targetSum - root.val);

        return result;
    }

    //Refer SubArraySumEqualsKWithNegativeNumbers560 for intuition
    public int pathSum_BackTracking(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        Map<Integer, Integer> prefixSumVsOccurrencesMap = new HashMap<>();
        prefixSumVsOccurrencesMap.put(0, 1);  //Default sum = 0 has one count

        return backtrack(root, 0, targetSum, prefixSumVsOccurrencesMap); //PrefixSum so start from ZERO
    }

    //BackTrack one pass
    public int backtrack(TreeNode root, int sumTillNow, int target, Map<Integer, Integer> map){
        if(root == null)
            return 0;
        sumTillNow += root.val;
        int res = map.getOrDefault(sumTillNow - target, 0);    //See if there is a sub-array sumTillNow equals to target
        map.put(sumTillNow, map.getOrDefault(sumTillNow, 0) + 1);

        //Extend to left and right child
        res += backtrack(root.left, sumTillNow, target, map) + backtrack(root.right, sumTillNow, target, map);

        map.put(sumTillNow, map.get(sumTillNow) - 1);   //TRICKY!!! Remove the current node, so it won't affect other path

        return res;
    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11)));
        //TreeNode root = new TreeNode(1, new TreeNode(2), null);
        PathSumIII437 sol = new PathSumIII437();

        System.out.println(sol.pathSum_BackTracking(root, 3));
    }
}
