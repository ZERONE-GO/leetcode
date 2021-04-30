package p1583;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                int key = i * 1000 + preferences[i][j];
                map.put(key, j);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < pairs.length; j++) {
                int x = pairs[i][0];
                int y = pairs[i][1];
                int u = pairs[j][0];
                int v = pairs[j][1];

                if (valid(map, x, y, u, v)||valid(map, x, y, v, u)) {
                    set.add(x);
                }
                if (valid(map, y, x, u, v) || valid(map, y, x, v, u)) {
                    set.add(y);
                }

            }
        }

        return set.size();
    }

    private boolean valid(Map<Integer, Integer> map, int x, int y, int u, int v) {
        return map.get(x * 1000 + y) > map.get(x * 1000 + u) && map.get(u * 1000 + v) > map.get(u * 1000 + x);
    }

}
