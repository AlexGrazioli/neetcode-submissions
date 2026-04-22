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
    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathOffered(root);

        return maxPathSum;
    }

    private int maxPathOffered(TreeNode node) {
        if (node == null) return 0;
        int leftOffer = maxPathOffered(node.left);
        int rightOffer = maxPathOffered(node.right);

        if (leftOffer < 0) leftOffer = 0;
        if (rightOffer < 0) rightOffer = 0;

        maxPathSum = Math.max(maxPathSum, node.val + leftOffer + rightOffer);

        return node.val + Math.max(leftOffer, rightOffer);
    }
}
