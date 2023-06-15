class Solution {

    // Bucket Sort
    public void sortColors(int[] nums) {
        bucketSortColors(nums);
    }

    private void bucketSortColors(int[] nums) {
        int[] bucket = new int[3];
        int currValue = -1;
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]] += 1;
        }
        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] != 0) {
                nums[k] = i;
                bucket[i] -= 1;
                k++;
            }
        }
    }

}