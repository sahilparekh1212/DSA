/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        if (root != null) {
            helper(root, "", ans);
        }
        return ans;
    }

    public void helper(TreeNode root, String prevPath, List<String> ans) {

        String newPath = prevPath + root.val;

        // Reached leaf
        if (root.left == null && root.right == null) {
            ans.add(newPath);
        }

        // Explore left
        if (root.left != null) {
            helper(root.left, newPath + "->", ans);
        }

        // Explore right
        if (root.right != null) {
            helper(root.right, newPath + "->", ans);
        }

    }
}