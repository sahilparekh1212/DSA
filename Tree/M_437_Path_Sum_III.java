class Solution {
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // helper with 3rd arg as count
        // int count = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode currNode = null;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                currNode = q.poll();
                helper(currNode, targetSum);
                if (currNode.left != null) {
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
            }
        }
        return count;
    }

    private void helper(TreeNode root, int targetSum) {
        if (root == null || root.val > Integer.MAX_VALUE || root.val < Integer.MIN_VALUE) {
            return;
        }
        if (root.val == targetSum) {
            count++;
            // cannot return from here as we have to count sub paths as well
            // return;
        }
        if (root.left != null) {
            helper(root.left, targetSum - root.val);
        }
        if (root.right != null) {
            helper(root.right, targetSum - root.val);
        }
    }
}