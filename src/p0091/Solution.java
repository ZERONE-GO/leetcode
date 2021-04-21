package p0091;

import java.util.Arrays;

public class Solution {
    public int numDecodings(String s) {
        int[] map = new int[s.length()];
        Arrays.fill(map, -1);
        return dp(s, map, 0);
    }

    private int dp(String s, int[] map, int i) {
        if (i >= s.length()) {
            return 1;
        }

        if (map[i] != -1) {
            return map[i];
        }

        if (s.charAt(i) == '0') {
            map[i] = 0;
            return map[i];
        }
        int count = 0;
        int number = 0;
        for (int j = i; j < s.length(); j++) {
            number = number * 10 + s.charAt(j) - '0';

            if (number >= 1 && number <= 26) {
                count += dp(s, map, j + 1);
            } else {
                break;
            }
        }
        map[i] = count;
        return map[i];
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("27"));
    }

}
