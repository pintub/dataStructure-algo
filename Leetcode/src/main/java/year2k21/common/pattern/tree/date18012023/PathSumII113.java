package year2k21.common.pattern.tree.date18012023;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return new ArrayList<>();
        }

        boolean isLeaf = isLeaf(root);

        if(isLeaf && targetSum == root.val) {
            LinkedList<Integer> newList = new LinkedList<>();
            newList.add(root.val);
            ArrayList<List<Integer>> wrapperList = new ArrayList<>();
            wrapperList.add(newList);
            return wrapperList;
        }

        if(isLeaf) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = pathSum(root.left, targetSum - root.val);
        result.addAll(pathSum(root.right, targetSum - root.val));

        for(List<Integer> linkedList : result) {
            linkedList.add(0, root.val);
        }

        return result;
    }

    private boolean isLeaf(TreeNode root) {
        return (root.left == null && root.right == null);
    }

    public List<List<Integer>> pathSum_FromLeetCodeBackTracking(TreeNode root, int sum){
        List<List<Integer>> result  = new LinkedList<>();
        List<Integer> currentResult  = new LinkedList<>();
        pathSum(root,sum,currentResult,result);
        return result;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {

        if (root == null)
            return;

        currentResult.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList<>(currentResult));
            currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
            return;
        } else {
            pathSum(root.left, sum - root.val, currentResult, result);
            pathSum(root.right, sum - root.val, currentResult, result);
        }
        currentResult.remove(currentResult.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        System.out.println(new PathSumII113().pathSum_FromLeetCodeBackTracking(root, 3));
    }
}
