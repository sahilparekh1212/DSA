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

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/solutions/33815/my-accepted-java-solution/

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/solutions/33904/java-double-stack-solution/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode currTreeNode = root;
        q.offer(root);
        while (!q.isEmpty()) {
            int qSize = q.size();
            List<Integer> currLevelList = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                currTreeNode = q.poll();
                if (currTreeNode.left != null) {
                    q.offer(currTreeNode.left);
                }
                if (currTreeNode.right != null) {
                    q.offer(currTreeNode.right);
                }
                if (ans.size() % 2 != 0) {
                    currLevelList.add(0, currTreeNode.val);
                } else {
                    currLevelList.add(currTreeNode.val);
                }
            }
            ans.add(currLevelList);
        }
        return ans;
    }
}