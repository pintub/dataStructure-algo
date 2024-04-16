package year2k21.common.pattern.tree.date18012023;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.ca/all/314.html
 * PreOrder & a HashMap
 */
public class BinaryTreeVerticalOrderTraversal314Premium {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> verticalLevelVsElements = new TreeMap<>();

        recursion(root, 0, verticalLevelVsElements);

        return new ArrayList<>(verticalLevelVsElements.values());
    }

    private void recursion(TreeNode root, int verticalLevel, final Map<Integer, List<Integer>> verticalLevelVsElements) {
        if(root == null) {
            return;
        }

        List<Integer> list = verticalLevelVsElements.getOrDefault(verticalLevel, new ArrayList<>());
        list.add(root.val);
        verticalLevelVsElements.put(verticalLevel, list);

        recursion(root.left, verticalLevel - 1, verticalLevelVsElements);
        recursion(root.right, verticalLevel + 1, verticalLevelVsElements);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7, new TreeNode(8), new TreeNode(9, new TreeNode(10), new TreeNode(11, null, new TreeNode(12))))));

        System.out.println(new BinaryTreeVerticalOrderTraversal314Premium().verticalOrder(root));
    }
}
