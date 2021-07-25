package p5825;

public class Solution {

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length, n = students[0].length;

        int[][] map = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = calculate(students[i], mentors[j]);
            }
        }

        boolean[] color = new boolean[m];

        return compatibility(color, 0, map, m, n);
    }

    private int compatibility(boolean[] color, int step, int[][] map, int m, int n) {
        if (step >= m) {
            return 0;
        }

        int tmp = 0;
        for (int i = 0; i < m; i++) {
            if (!color[i]) {
                color[i] = true;
                tmp = Math.max(tmp, map[step][i] + compatibility(color, step + 1, map, m, n));
                color[i] = false;
            }
        }

        return tmp;
    }

    private int calculate(int[] student, int[] mentor) {
        int res = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i] == mentor[i]) {
                res++;
            }
        }
        return res;
    }

}
