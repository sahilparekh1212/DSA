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

// https://leetcode.com/problems/binary-search-tree-iterator/solutions/1965120/easy-iterative-using-stack-space-o-h-instead-of-o-n/

// https://leetcode.com/problems/binary-search-tree-iterator/solutions/52525/my-solutions-in-3-languages-with-stack/

class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        addToStackInorder(root);
    }

    public int next() {
        int ans = -1;
        if (hasNext()) {
            TreeNode currNode = st.pop();
            ans = currNode.val;
            addToStackInorder(currNode.right);
        }
        return ans;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void addToStackInorder(TreeNode node) {
        // add all possible left nodes of the node on stack
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */