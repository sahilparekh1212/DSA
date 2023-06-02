class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1, mid = 0, peak = -1;
        while (l <= r) {
            mid = (l + r) / 2;
            if ((mid == 0 || (nums[mid] > nums[mid - 1]))
                    && ((mid + 1 < nums.length && nums[mid] > nums[mid + 1]) || (mid == nums.length - 1))) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else if (nums[mid] < nums[mid - 1]) {
                r = mid - 1;
            }

        }
        return -1;
    }
}