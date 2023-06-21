class Solution {
    public boolean isValidBST(TreeNode root) {
        // Do not use Integer.MAX_VALUE && Integer.MIN_VALUE > Using it will cause 2nd
        // if to pass in case of single node tree
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        return (helper(root.left, min, root.val) && helper(root.right, root.val, max));
    }
}