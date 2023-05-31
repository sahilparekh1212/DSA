class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = ((l + r) / 2);
            if (arr[mid] < arr[mid + 1]) {
                // move l to right
                l = mid + 1;
            } else {
                // move r to left
                r = mid - 1;
            }
        }
        return l;
    }
}