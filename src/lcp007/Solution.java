package lcp007;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < relation.length; i++) {
            List<Integer> list = map.getOrDefault(relation[i][0], new ArrayList<Integer>());
            list.add(relation[i][1]);
            map.put(relation[i][0], list);
        }

        return dfs(map, 0, 0, k, n);
    }

    private int dfs(Map<Integer, List<Integer>> map, int i, int step, int k, int n) {
        if (step == k) {
            return i == n - 1 ? 1 : 0;
        }

        int ans = 0;
        List<Integer> list = map.getOrDefault(i, new ArrayList<Integer>());

        for (int nxt : list) {
            ans += dfs(map, nxt, step + 1, k, n);
        }

        return ans;
    }

}
