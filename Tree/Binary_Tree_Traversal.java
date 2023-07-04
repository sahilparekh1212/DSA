class Solution {

    // O(n) O(n)
    public List<Integer> orderTraversal1(TreeNode root, String order) {
        order = order.toUpperCase();
        if (root == null) {
            return List.of();
        }
        List<Integer> ansList = new ArrayList<Integer>();
        if (order.equals("PRE")) {
            ansList.add(root.val);
        }
        ansList.addAll(orderTraversal1(root.left, order));
        if (order.equals("IN")) {
            ansList.add(root.val);
        }
        ansList.addAll(orderTraversal1(root.right, order));
        if (order.equals("POST")) {
            ansList.add(root.val);
        }
        return ansList;
    }

    // O(n) O(n)
    private List<Integer> orderTraversal2(TreeNode root, String order) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        order = order.toUpperCase();
        List<Integer> ansList = new ArrayList<>();
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            if (curr != null) {
                if (curr.left == null && curr.right == null) {
                    ansList.add(curr.val);
                } else {
                    if (order.equals("POST")) {
                        st.push(new TreeNode(curr.val));
                    }
                    st.push(curr.right);
                    if (order.equals("IN")) {
                        st.push(new TreeNode(curr.val));
                    }
                    st.push(curr.left);
                    if (order.equals("PRE")) {
                        st.push(new TreeNode(curr.val));
                    }
                }
            }
        }
        return ansList;
    }

}