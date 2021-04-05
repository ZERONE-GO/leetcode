package game004;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 0, 0 } };

    public boolean escapeMaze(List<List<String>> maze) {
        int n = maze.get(0).size();
        int m = maze.get(0).get(0).length();
        Status begin = new Status(0, 0, 0, true, true, -1, -1);

        return mock(maze, begin, n - 1, m - 1);
    }

    private boolean mock(List<List<String>> maze, Status s, int n, int m) {
        System.out.println(s.toString());
        if (s.x == n && s.y == m) {
            return true;
        }
        if (s.t >= maze.size() - 1) {
            return false;
        }

        List<String> map = maze.get(s.t + 1);
        for (int i = 0; i < move.length; i++) {
            if (s.x + move[i][0] >= 0 && s.x + move[i][0] <= n && s.y + move[i][1] >= 0 && s.y + move[i][1] <= m) {
                String row = map.get(s.x + move[i][0]);
                if (row.charAt(s.y + move[i][1]) == '.' || (s.x + move[i][0] == s.mx && s.y + move[i][1] == s.my)) {
                    Status next = new Status(s.t + 1, s.x + move[i][0], s.y + move[i][1], s.m1, s.m2, s.mx, s.my);
                    if (mock(maze, next, n, m)) {
                        return true;
                    }
                } else {
                    if (s.m1) {
                        Status next = new Status(s.t + 1, s.x + move[i][0], s.y + move[i][1], false, s.m2, s.mx, s.my);
                        if (mock(maze, next, n, m)) {
                            return true;
                        }
                    }
                    if (s.m2) {
                        Status next = new Status(s.t + 1, s.x + move[i][0], s.y + move[i][1], s.m1, false, s.mx, s.my);
                        next.mx = s.x + move[i][0];
                        next.my = s.y + move[i][1];
                        if (mock(maze, next, n, m)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public class Status {
        int t;
        int x;
        int y;
        boolean m1;
        boolean m2;
        int mx;
        int my;

        public Status(int t, int x, int y, boolean m1, boolean m2, int mx, int my) {
            this.t = t;
            this.x = x;
            this.y = y;
            this.m1 = m1;
            this.m2 = m2;
            this.mx = mx;
            this.my = my;
        }
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        List<List<String>> maze = new ArrayList<>();
        // List<String> t1 = new ArrayList<>();
        // t1.add(".#.");
        // t1.add("#..");
        // maze.add(t1);
        //
        // List<String> t2 = new ArrayList<>();
        // t2.add("...");
        // t2.add(".#.");
        // maze.add(t2);
        //
        // List<String> t3 = new ArrayList<>();
        // t3.add(".##");
        // t3.add(".#.");
        // maze.add(t3);
        //
        //
        // List<String> t4 = new ArrayList<>();
        // t4.add("..#");
        // t4.add(".#.");
        // maze.add(t4);

        List<String> t1 = new ArrayList<>();
        t1.add("...");
        t1.add("...");
        t1.add("...");
        maze.add(t1);

        List<String> t2 = new ArrayList<>();
        t2.add(".##");
        t2.add("###");
        t2.add("##.");
        maze.add(t2);

        List<String> t3 = new ArrayList<>();
        t3.add(".##");
        t3.add("###");
        t3.add("##.");
        maze.add(t3);

        List<String> t4 = new ArrayList<>();
        t4.add(".##");
        t4.add("###");
        t4.add("##.");
        maze.add(t4);

        List<String> t5 = new ArrayList<>();
        t5.add(".##");
        t5.add("###");
        t5.add("##.");
        maze.add(t5);

        List<String> t6 = new ArrayList<>();
        t6.add(".##");
        t6.add("###");
        t6.add("##.");
        maze.add(t6);

        List<String> t7 = new ArrayList<>();
        t7.add(".##");
        t7.add("###");
        t7.add("##.");
        maze.add(t7);

        System.out.println(s.escapeMaze(maze));
    }
}
