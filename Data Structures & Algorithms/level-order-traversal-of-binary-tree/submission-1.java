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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root == null) return levelOrderTraversal;

        queue.offer(root);
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            levelOrderTraversal.add(new ArrayList<>());

            for (int i = 0; i < len; i++) {
                TreeNode current = queue.poll();
                assert current != null;
                levelOrderTraversal.get(currentLevel).add(current.val);

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            currentLevel++;
        }

        return levelOrderTraversal;
    }
}
