/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
                List<Integer> nodes = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = deque.poll();
                nodes.add(currentNode.val);
                if (currentNode.left != null) deque.offer(currentNode.left);
                if (currentNode.right != null) deque.offer(currentNode.right);
            }
        }
        Collections.sort(nodes);
        return nodes.get(k-1);
    }
}
