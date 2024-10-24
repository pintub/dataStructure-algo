package year2k21.common.pattern.tree.date18012023;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Convert to Graph
 * Tree has child info, need to add parent info -- Thus DFS using preOrder, Creates a map of nodeVsParent
 * Then use BFS(use Visited DS like in Graph) to find distance k nodes
 */
public class AllNodesDistanceKInBinaryTree863 {

    Map<TreeNode, TreeNode> nodeVsParentNode;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        nodeVsParentNode = new HashMap<>();
        dfs(root, root);                //DFS using PreOrder

        Queue<TreeNode> queue = new LinkedList<>(); //BFS
        queue.add(target);

        Set<TreeNode> visited = new HashSet<>(); //Visited DS like in Graph
        visited.add(target);

        int dist = 0;
        while (!queue.isEmpty() && dist<K) {
            final int tempSize = queue.size();
            dist++;
            for(int i=1;i<=tempSize;i++){
                TreeNode currentNode = queue.poll();
                if (!visited.contains(currentNode.left) && currentNode.left!=null) {
                    visited.add(currentNode.left);
                    queue.offer(currentNode.left);
                }
                if (!visited.contains(currentNode.right) && currentNode.right!=null) {
                    visited.add(currentNode.right);
                    queue.offer(currentNode.right);
                }
                TreeNode parent = nodeVsParentNode.get(currentNode);
                if (!visited.contains(parent)) {
                    visited.add(parent);
                    queue.offer(parent);
                }
            }
        }

        return queue.stream() //Finally Queue will have nodes which are at distance k
                .map(n -> n.val)
                .collect(Collectors.toList());
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            nodeVsParentNode.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
