package p5776;

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (equal(mat, target)) {
                return true;
            } else {
                rotate(mat);
            }
        }
        return false;
    }

    private void rotate(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < mat.length / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[n - 1 - j][i];
                mat[n - 1 - j][i] = mat[n - i - 1][n - 1 - j];
                mat[n - i - 1][n - 1 - j] = mat[j][n - i - 1];
                mat[j][n - i - 1] = tmp;
            }
        }
    }

    private boolean equal(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int[][] mat = { { 0, 1, 0, 1, 0, 1 }, { 0, 1, 0, 1, 1, 0 }, { 1, 1, 1, 0, 1, 0 }, { 0, 0, 0, 1, 0, 0 },
                { 1, 1, 0, 1, 0, 1 }, { 1, 1, 1, 0, 0, 1 } };
        int[][] target = { { 1, 0, 0, 0, 1, 1 }, { 0, 1, 1, 0, 0, 0 }, { 1, 1, 0, 1, 1, 0 }, { 0, 0, 1, 0, 0, 1 },
                { 1, 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 1, 1 } };
        Solution s = new Solution();
        System.out.println(s.findRotation(mat, target));
    }
}
