class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesHelper(root, false);
    }

    public int sumOfLeftLeavesHelper(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (isLeft && root.left == null && root.right == null) {
            return root.val;
        }
        return sumOfLeftLeavesHelper(root.left, true) + sumOfLeftLeavesHelper(root.right, false);
    }
}