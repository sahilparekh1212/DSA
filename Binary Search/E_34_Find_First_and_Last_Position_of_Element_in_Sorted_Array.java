class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l <= r) {
            mid = ((l + r) / 2);
            if (nums[mid] == target) {
                int i = mid, j = mid;
                while (i >= 0 && nums[i] == target) {
                    i--;
                }
                while (j < nums.length && nums[j] == target) {
                    j++;
                }

                return (new int[] { i + 1, j - 1 });
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (new int[] { -1, -1 });
    }
}