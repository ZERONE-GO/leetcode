package p1787;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {

    public int minChanges(int[] nums, int k) {
        int[][] counts = new int[k][1025];
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            counts[i % k][nums[i]]++;
            counts[i % k][1024]++;

            Set<Integer> set = map.getOrDefault(i % k, new HashSet<Integer>());
            set.add(nums[i]);
            map.put(i % k, set);
        }
        int[][] dp = new int[k][1024];
        int[] mdp = new int[k];

        for (int i = 0; i < k; i++) {
            Arrays.fill(dp[i], nums.length);
        }
        Arrays.fill(mdp, nums.length);

        for (int i = 0; i < 1024; i++) {
            dp[0][i] = counts[0][1024] - counts[0][i];
            mdp[0] = Math.min(mdp[0], dp[0][i]);
        }

        for (int i = 1; i < k; i++) {
            Set<Integer> set= map.getOrDefault(i, new HashSet<Integer>());
            for (int j = 0; j < 1024; j++) {
                dp[i][j] = mdp[i-1] + counts[i][1024];
                for (int l : set) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j ^ l] + counts[i][1024] - counts[i][l]);
                    mdp[i] = Math.min(mdp[i], dp[i][j]);
                }
            }
        }

        return dp[k - 1][0];
    }
}
