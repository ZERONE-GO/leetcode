package p0074;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[1].length;

        int left = -1, right = m - 1;
        while (left <= right) {
            int mid = (right - left + 1) / 2 + left;
            if (matrix[mid][0] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        int row = left;
        if (row >= 0) {
            left = 0;
            right = n;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (matrix[row][mid] == target) {
                    return true;
                } else if (matrix[row][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        return false;
    }

}
