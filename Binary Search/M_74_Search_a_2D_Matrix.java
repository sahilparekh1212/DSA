class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1, mid = 0, targetRow = -1;
        // find targetRow
        while (l <= r) {
            mid = (l + r) / 2;
            if (target >= matrix[mid][0]
                    && ((mid + 1 <= matrix.length - 1 && target < matrix[mid + 1][0]) || (mid == matrix.length - 1))) {
                targetRow = mid;
                break;
            } else if (target < matrix[mid][0]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (targetRow == -1) {
            return false;
        }

        // find target
        l = 0;
        r = matrix[targetRow].length - 1;
        mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (target == matrix[targetRow][mid]) {
                return true;
            } else if (target < matrix[targetRow][mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    // have to select a space from where changing row and column leads to larger or
    // smaller element.
    // i.e. We cannot start from top left corner or right bottom corner

    public boolean searchMatrix2(int[][] matrix, int target) {
        int r = 0, c = matrix[0].length - 1;
        while (r < matrix.length && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target < matrix[r][c]) {
                c = c - 1;
            } else {
                r = r + 1;
            }
        }
        return false;
    }

    public boolean searchMatrix3(int[][] matrix, int target) {
        int c = 0, r = matrix.length - 1;
        while (c < matrix[0].length && r >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) {
                c = c + 1;
            } else {
                r = r - 1;
            }
        }
        return false;
    }
}