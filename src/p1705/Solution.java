package p1705;

import java.util.PriorityQueue;

public class Solution {
    
    
    public int eatenApples(int[] apples, int[] days) {
        int count =0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });

        for(int i=0; i < apples.length; i ++) {
            if(apples[i] > 0) {
                int[] couple = new int[2];
                couple[0] = i + days[i] -1;
                couple[1] = apples[i];
                queue.add(couple);
            }

            while(!queue.isEmpty()) {
                int[] da = queue.peek();
                if(da[0] >= i && da[1] > 0) {
                    da[1] --;
                    count ++;
                    break;
                } else {
                    queue.poll();
                }
            }
        }
        
        int day = apples.length;
        
        while(!queue.isEmpty()) {
            int[] da = queue.poll();
            if(da[0] >= day) {
                int apple = Math.min(da[1], da[0] - day + 1);
                count += apple;
                day += apple;
            }
        }
        
        return count;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        int[] apples = {1,2,3,5,2};
        int[] days = {3,2,1,4,2};
        System.out.println(s.eatenApples(apples, days));
    }

}
