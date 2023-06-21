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