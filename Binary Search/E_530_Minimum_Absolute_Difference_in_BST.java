class Solution {
    int ans = (int) Integer.MAX_VALUE;
    TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        // traverse tree and keep track of prev(node) and ans(min)
        inOrder(root);
        return ans;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (prev != null) {
            ans = Math.min(ans, root.val - prev.val);
        }
        prev = root;
        inOrder(root.right);
    }
}