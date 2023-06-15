class Solution {

    // merge sort
    public int[] sortArray(int[] nums) {
        mergeSortArray(nums);
        return nums;
    }

    private void mergeSortArray(int[] nums) {
        int numsLength = nums.length;

        // base case
        if (numsLength < 2) {
            return;
        }
        int midIndex = nums.length / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[numsLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = nums[i];
        }
        for (int i = midIndex; i < numsLength; i++) {
            rightHalf[i - midIndex] = nums[i];
        }

        // recursive terminations
        sortArray(leftHalf);
        sortArray(rightHalf);
        mergeTwoSortedArray(nums, leftHalf, rightHalf);
    }

    private void mergeTwoSortedArray(int[] nums, int[] leftHalf, int[] rightHalf) {
        int i = 0, j = 0, k = 0;
        int leftHalfLength = leftHalf.length;
        int rightHalfLength = rightHalf.length;

        while (i < leftHalfLength && j < rightHalfLength) {
            if (leftHalf[i] <= rightHalf[j]) {
                nums[k] = leftHalf[i];
                i++;
            } else {
                nums[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftHalfLength) {
            nums[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightHalfLength) {
            nums[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}