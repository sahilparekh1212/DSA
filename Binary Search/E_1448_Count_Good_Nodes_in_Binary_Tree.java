// https://leetcode.com/problems/count-good-nodes-in-binary-tree/solutions/635555/java-100-simple-easy-code-using-pre-order-tree-traversal/

class Solution {
    int ans = 0;

    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return ans;
    }

    private void helper(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            ans++;
        }
        max = Math.max(max, root.val);
        helper(root.left, max);
        helper(root.right, max);
    }
}