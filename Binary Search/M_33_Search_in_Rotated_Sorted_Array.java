// https://leetcode.com/problems/search-in-rotated-sorted-array/solutions/14436/revised-binary-search/
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = ((l + r) / 2);
            if (nums[mid] == target) {
                return mid;
            }

            // look into left sorted
            if (nums[l] <= nums[mid]) {
                // out of range in left sorted part
                if (nums[mid] < target || nums[l] > target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                // out of range in right sorted part
                if (nums[mid] > target || nums[r] < target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}