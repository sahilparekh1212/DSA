class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q || p == null || q == null) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l == null && r == null) {
            return null;
        }
        if (l != null && r != null) {
            return root;
        }
        if (l == null) {
            return r;
        }
        return l;
    }

    // private void helperNotWorking(){
    // if(root==null || root==p || root==q || p==null || q==null){
    // return root;
    // }
    // if(root.val>p.val && root.val>q.val){
    // return lowestCommonAncestor(root.left,p,q);
    // }
    // if(root.val<p.val && root.val<q.val){
    // return lowestCommonAncestor(root.right,p,q);
    // }
    // return root;
    // }
}