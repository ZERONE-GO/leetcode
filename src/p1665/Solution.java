package p1665;

import java.util.Arrays;

public class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (t1, t2) ->{
            return t2[1] - t2[0] - t1[1] + t1[0];
        });

        int res = 0;
        int remain = 0;

        for(int i=0; i < tasks.length; i ++) {
            if(remain < tasks[i][1]) {
                res = res + tasks[i][1] - remain;
                remain = tasks[i][1] - tasks[i][0];
            } else {
                remain = remain - tasks[i][0];
            }
        }
        return res;
    }
}
