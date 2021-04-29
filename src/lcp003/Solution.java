package lcp003;

public class Solution {

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int mx = 0, my = 0;
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'U') {
                my++;
            } else {
                mx++;
            }
        }

        for (int i = 0; i < obstacles.length; i++) {
            if (obstacles[i][0] > x || obstacles[i][1] > y) {
                continue;
            }

            if (access(command, mx, my, obstacles[i][0], obstacles[i][1])) {
                return false;
            }
        }

        return access(command, mx, my, x, y);
    }

    private boolean access(String command, int mx, int my, int x, int y) {
        int k = Math.min(x / mx, y / my);
        x = x - k * mx;
        y = y - k * my;

        int x1 = 0, y1 = 0;
        for (int i = 0; i < command.length(); i++) {
            if (x1 == x && y1 == y) {
                return true;
            } else if (x1 > x || y1 > y) {
                return false;
            }
            if (command.charAt(i) == 'U') {
                y1++;
            } else {
                x1++;
            }
        }

        return x1==x &&y1==y;
    }
    
    public static void main(String args[]) {
        int[][] obstacles = {{7, 7}, {0, 5}, {2, 7}, {8, 6}, {8, 7}, {6, 5}, {4, 4}, {0, 3}, {3, 6}};
        Solution s = new Solution();
        boolean result = s.robot("URRURRR", obstacles, 4915, 1966);
        System.out.println(result);
    }
}
