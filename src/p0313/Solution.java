package p0313;

import java.util.PriorityQueue;

public class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ans = new int[n];
        ans[0] = 1;

        int[] index = new int[primes.length];

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> {
            return ans[index[a]] * primes[a] - ans[index[b]] * primes[b];
        });

        for (int i = 0; i < primes.length; i++) {
            index[i] = 0;
            queue.add(i);
        }
        
        int i = 1;
        while(i < n) {
            int j = queue.poll();
            ans[i] = ans[index[j]] * primes[j];
            index[j]++;
            queue.add(j);
            if(ans[i] > ans[i-1]) {
                i ++;
            }
        }

        return ans[n - 1];
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        int[] primes = {2, 7 ,13, 19};
        s.nthSuperUglyNumber(12, primes);
    }

}
