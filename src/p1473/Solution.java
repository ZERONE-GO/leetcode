package p1473;

public class Solution {

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] map = new int[m][n][target];

        for (int j = 0; j < n; j++) {
            for (int t = 0; t < target; t++) {
                if (houses[0] == 0) {
                    if (t == 0) {
                        map[0][j][t] = cost[0][j];
                    } else {
                        map[0][j][t] = -1;
                    }
                } else {
                    if (houses[0] == j + 1 && t == 0) {
                        map[0][j][t] = 0;
                    } else {
                        map[0][j][t] = -1;
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int t = 0; t < target; t++) {
                    if (houses[i] == 0) {
                        int v = -1;
                        if (map[i - 1][j][t] >= 0) {
                            v = map[i - 1][j][t];
                        }
                        if (t > 0) {
                            for (int j2 = 0; j2 < n; j2++) {
                                if (map[i - 1][j2][t - 1] >= 0 && j2 != j) {
                                    v = v == -1 ? map[i - 1][j2][t - 1] : Math.min(v, map[i - 1][j2][t - 1]);
                                }
                            }
                        }

                        if (v == -1) {
                            map[i][j][t] = -1;
                        } else {
                            map[i][j][t] = v + cost[i][j];
                        }
                    } else {
                        if (houses[i] != j + 1) {
                            map[i][j][t] = -1;
                        } else {
                            int v = -1;
                            if (map[i - 1][j][t] >= 0) {
                                v = map[i - 1][j][t];
                            }
                            if (t > 0) {
                                for (int j2 = 0; j2 < n; j2++) {
                                    if (map[i - 1][j2][t - 1] >= 0 && j2 != j) {
                                        v = v == -1 ? map[i - 1][j2][t - 1] : Math.min(v, map[i - 1][j2][t - 1]);
                                    }
                                }
                            }

                            if (v == -1) {
                                map[i][j][t] = -1;
                            } else {
                                map[i][j][t] = v;
                            }
                        }
                    }
                }
            }
        }

        int res = -1;
        for (int j = 0; j < n; j++) {
            if (map[m - 1][j][target - 1] != -1) {
                res = res == -1 ? map[m - 1][j][target - 1] : Math.min(res, map[m - 1][j][target - 1]);
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int[] houses = { 0, 2, 1, 2, 0 };
        int[][] costs = { { 1, 10 }, { 10, 1 }, { 10, 1 }, { 1, 10 }, { 5, 1 } };
        Solution s = new Solution();
        s.minCost(houses, costs, 5, 2, 3);
    }

}
