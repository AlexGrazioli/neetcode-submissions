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

public class Codec {
    StringBuilder builder = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();

        dfsSerialize(root, builder);

        return builder.toString();
    }

    private void dfsSerialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("null,");
            return;
        }
        builder.append(root.val).append(",");
        
        dfsSerialize(root.left, builder);
        dfsSerialize(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));

        return dfsDeserialize(queue);
    }

    private TreeNode dfsDeserialize(Queue<String> queue) {
        String currentValue = queue.poll();
        if (currentValue == null || currentValue.equals("null")) return null;
        return new TreeNode(Integer.parseInt(currentValue), dfsDeserialize(queue), dfsDeserialize(queue));
    }
}
