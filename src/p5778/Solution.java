package p5778;

class Solution {
    public int minFlips(String s) {
        int res = s.length();

        int[][] map = new int[s.length() + 1][2];
        for (int i = 0; i < s.length(); i++) {
            if ((i & 1) == 0 && s.charAt(i) != '0') {
                map[i + 1][0] = map[i][0] + 1;
            } else if ((i & 1) == 1 && s.charAt(i) != '1') {
                map[i + 1][0] = map[i][0] + 1;
            } else {
                map[i + 1][0] = map[i][0];
            }

            if ((i & 1) == 0 && s.charAt(i) != '1') {
                map[i + 1][1] = map[i][1] + 1;
            } else if ((i & 1) == 1 && s.charAt(i) != '0') {
                map[i + 1][1] = map[i][1] + 1;
            } else {
                map[i + 1][1] = map[i][1];
            }
        }

        int len = s.length() - 1;
        int tmp = 0;
        for (int i = len; i >= 0; i--) {
            if(tmp + map[i][1] < res) {
                res = tmp + map[i+1][1];
            }
            if (((len-i) & 1) == 0 && s.charAt(i) != '0') {
                tmp ++;
            } else if(((len-i) & 1) == 1 && s.charAt(i) != '1') {
                tmp ++;
            }
        }
        
        tmp = 0;
        for (int i = len; i >= 0; i--) {
            if(tmp + map[i][0] < res) {
                res = tmp + map[i+1][0];
            }
            if (((len-i) & 1) == 0 && s.charAt(i) != '1') {
                tmp ++;
            } else if(((len-i) & 1) == 1 && s.charAt(i) != '0') {
                tmp ++;
            }
        }

        return res;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.minFlips("10100101"));
    }
}
