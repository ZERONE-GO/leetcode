package p5790;

public class Solution {

    public int[] minDifference(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        int[][] map = new int[nums.length+1][101];
        
        for(int i=0; i < nums.length; i ++) {
            for(int j=0; j < 101; j ++) {
                map[i+1][j] = j== nums[i] ? map[i][j] + 1 : map[i][j];
            }
        }

        for (int i = 0; i < queries.length; i++) {
            res[i] = diff(map, queries[i]);
        }

        return res;
    }

    private int diff(int[][] map, int[] query) {
        int left = 1, right = 1;
        while (left < 101 && !exist(map, query[0], query[1], left)) {
            left++;
        }

        int res = Integer.MAX_VALUE;
        right = left + 1;
        while (right < 101) {
            if (exist(map, query[0], query[1], right)) {
                if (res > right - left) {
                    res = right - left;
                }
                left = right;
            }
            right++;
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private boolean exist(int[][] map, int s, int e, int v) {
        return map[e+1][v] - map[s][v] > 0;
    }
    
    public static void main(String args[]) {
        int[] nums = {4, 6, 2 ,2 ,7};
        int[][] queries = {{0, 4}};
        Solution s = new Solution();
        s.minDifference(nums, queries);
                        
                       
    }
}
