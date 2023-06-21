class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            int nextGreaterValue = -1;
            boolean numFound = false;
            while (j < nums2.length && nextGreaterValue == -1) {
                if (nums2[j] == nums1[i]) {
                    numFound = true;
                }
                if (nums2[j] > nums1[i] && numFound) {
                    nextGreaterValue = nums2[j];
                    break;
                }
                j++;
            }
            ans[i] = nextGreaterValue;
        }
        return ans;
    }
}