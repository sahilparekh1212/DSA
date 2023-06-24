public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        int mid = 1;
        while (l <= r) {
            mid = (int) (l + (r - l) / 2);
            if (isBadVersion(mid) && !isBadVersion(mid - 1)) {
                return mid;
            } else if (!isBadVersion(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return mid;
    }
}