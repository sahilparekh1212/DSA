class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (isSame(root, subRoot)) {
            return true;
        }
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return (isSame(a.left, b.left) && isSame(a.right, b.right));
    }
}