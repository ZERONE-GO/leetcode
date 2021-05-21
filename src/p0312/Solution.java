package p0312;

import java.util.Arrays;

public class Solution {
    public int maxCoins(int[] nums) {
        int[] append = new int[nums.length + 2];
        append[0] = append[nums.length+1] = 1;
        
        for(int i=0; i < nums.length; i ++) {
            append[i+1] = nums[i];
        }

        int[][] map = new int[append.length][append.length];
        for(int i=0; i < map.length; i ++) {
            Arrays.fill(map[i], -1);
        }
        return calc(map, append, 0, append.length - 1);
    }

    private int calc(int[][] map, int[] append, int s, int e) {
        if(s >= e-1) {
            return 0;
        }

        if(map[s][e] == -1) {
            for(int i=s +1 ; i < e; i ++) {
                int value = append[s] * append[i] * append[e];
                value = value + calc(map, append, s, i) + calc(map, append, i, e);
                map[s][e] = Math.max(value, map[s][e]);
            }
        }
        return map[s][e];
    }
}
