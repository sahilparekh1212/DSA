class Solution {

    // O(logn) O(1)
    public int search(int[] nums, int target) {
        int foundAtIndex = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right && foundAtIndex == -1) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                foundAtIndex = mid;
            }
        }
        return foundAtIndex;
    }
}