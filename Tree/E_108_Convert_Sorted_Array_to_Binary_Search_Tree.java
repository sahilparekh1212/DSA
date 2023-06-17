class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode tn = new TreeNode();
        tn.val = nums[mid];
        tn.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        tn.right = sortedArrayToBSTHelper(nums, mid + 1, right);
        return tn;
    }
}