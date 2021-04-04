package p5723;

import java.util.Arrays;

public class Solution {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] result = new int[k];

        Arrays.sort(logs, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        int id = logs[0][0];
        int time = logs[0][1];
        int count = 0;
        for (int i = 1; i < logs.length; i++) {
            if (logs[i][0] == id) {
                if (logs[i][1] != time) {
                    time = logs[i][1];
                    count++;
                }
            } else {
                result[count]++;
                id = logs[i][0];
                time = logs[i][1];
                count = 0;
            }
        }
        result[count]++;

        return result;
    }

}
