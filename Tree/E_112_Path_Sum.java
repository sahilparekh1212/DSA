class Solution {
    public boolean hasPathSum(TreeNode node, int targetSum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null && node.val == targetSum) {
            return true;
        }
        return (hasPathSum(node.left, targetSum - node.val) || hasPathSum(node.right, targetSum - node.val));
    }
}