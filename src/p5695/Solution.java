package p5695;

public class Solution {

    public int maxScore(int[] nums) {
        int len = nums.length;

        int[][] g = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                g[i][j] = gcd(nums[i], nums[j]);
                g[j][i] = g[i][j];
            }
        }
        
        boolean[] used = new boolean[len];

        return score(g, used, 0, 1, len);
    }

    private int score(int[][] g, boolean[] used, int mg, int step, int len) {
        if (step > len / 2) {
            return 0;
        }

        int score = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if(used[i]) {
                continue;
            }
            used[i] = true;
            for (int j = i + 1; j < len; j++) {
                if(used[j]) {
                    continue;
                }
                used[j] = true;
                if (g[i][j] >= mg) {
                    int tmp = g[i][j] * step + score(g, used, g[i][j], step + 1, len);
                    if (tmp > score) {
                        score = tmp;
                    }
                }
                used[j] = false;
            }
            used[i] = false;
        }

        return score;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        int[] nums= {1,2,3,4,5,6};
        System.out.println(s.maxScore(nums));
    }

}
