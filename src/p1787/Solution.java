package p1787;

public class Solution {

    private int ans;

    public int minChanges(int[] nums, int k) {
        int[][] counts = new int[k][1025];

        for (int i = 0; i < nums.length; i++) {
            counts[i % k][nums[i]]++;
            counts[i % k][1024]++;
        }
        ans = nums.length;

        change(counts, 0, 0, k, 0);

        return ans;
    }

    private void change(int[][] counts, int i, int v, int k, int res) {
        if (i == k - 1) {
            res = res + counts[i][1024] - counts[i][v];
            if (res < ans) {
                ans = res;
            }
            return;
        }

        for (int j = 0; j < 1024; j++) {
            if (res + counts[i][1024] - counts[i][j] >= ans) {
                continue;
            }
            change(counts, i + 1, v ^ j, k, res + counts[i][1024] - counts[i][j]);
        }
    }
}
