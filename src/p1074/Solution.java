package p1074;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    sum[k] = sum[k] + matrix[j][k];
                }
                
                Map<Integer, Integer> map = new HashMap<>();
                int pre = 0;
                map.put(0, 1);
                for (int k = 0; k < n; k++) {
                    pre = pre + sum[k];
                    if (map.containsKey(pre - target)) {
                        ans += map.get(pre - target);
                    }
                    map.put(pre, map.getOrDefault(pre, 0) + 1);
                }
            }//end for j
        }// end for i

        return ans;
    }
}
