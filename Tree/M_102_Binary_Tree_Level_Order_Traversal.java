// https://leetcode.com/problems/binary-tree-level-order-traversal/solutions/33562/java-1ms-dfs-recursive-solution-and-2ms-bfs-iterative-solution/

// https://leetcode.com/problems/binary-tree-level-order-traversal/solutions/33445/java-solution-using-dfs/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

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
                currLevelList.add(currTreeNode.val);
            }
            ans.add(currLevelList);

        }

        return ans;

    }
}