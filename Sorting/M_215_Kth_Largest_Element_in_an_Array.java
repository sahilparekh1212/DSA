class Solution {
    // TC:O(nlogn), SC:O(1)
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // TC:O(n), SC:O(1)
    public int findKthLargest(int[] nums, int k) {
        partialQuickSort(nums, 0, nums.length - 1, k - 1);
        return nums[k - 1];
    }

    private void partialQuickSort(int[] nums, int lowIndex, int highIndex, int k) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivot = nums[highIndex];
        int l = lowIndex;
        int r = highIndex;

        while (l < r) {
            // find first min on lhs
            while (l < r && nums[l] >= pivot) {
                l++;
            }
            // find first max on rhs
            while (l < r && nums[r] <= pivot) {
                r--;
            }
            swap(nums, l, r);
        }

        // l==r
        swap(nums, r, highIndex);
        // swap(nums,l,highIndex);

        if (k < l) {
            partialQuickSort(nums, lowIndex, l - 1, k);
        } else if (k > l) {
            partialQuickSort(nums, l + 1, highIndex, k);
        }

    }

    private int[] swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        return nums;
    }
}