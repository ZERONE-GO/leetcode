package p5736;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (a, b) -> {
            if (tasks[a][0] == tasks[b][0]) {
                return tasks[a][1] - tasks[b][1];
            }
            return tasks[a][0] - tasks[b][0];
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            if(tasks[a][1] == tasks[b][1]) {
                return a - b;
            }
            return tasks[a][1] - tasks[b][1];
        });

        int i = 0, j = 0, time =0;
        while (i < n) {
            if (queue.isEmpty()) {
                queue.add(ids[i]);
                i++;
            } else {
                int o = queue.poll();
                time = Math.max(time, tasks[o][0]) + tasks[o][1];
                while (i < n) {
                    if (tasks[ids[i]][0] <= time) {
                        queue.add(ids[i]);
                        i++;
                    } else {
                        break;
                    }
                }
                ans[j] = o;
                j++;
            }
        }
        
        while(!queue.isEmpty()) {
            ans[j] = queue.poll();
            j ++;
        }

        return ans;
    }

}
