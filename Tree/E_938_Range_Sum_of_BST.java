class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            // go right only
            // If we go to left, it will be out of range
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            // go left only
            // If we go to right, it will be out of range
            return rangeSumBST(root.left, low, high);
        }
        // keep going left and right
        return (root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high));

    }
}