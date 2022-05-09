package year2k21.common.pattern.tree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree98 {

    private List<Integer> values = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {

        inOrderTraversal(root);

        return isOrdered(values);
    }

    private boolean isOrdered(List<Integer> values) {
        for(int index = 1; index < values.size(); ++index){
            if(values.get(index) <= values.get(index-1))
                return false;
        }

        return true;
    }

    private void inOrderTraversal(TreeNode root) {
        if(root == null)
            return;

        inOrderTraversal(root.left);
        values.add(root.val);
        inOrderTraversal(root.right);
    }
}
