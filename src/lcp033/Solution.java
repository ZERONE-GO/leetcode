package lcp033;

import java.util.PriorityQueue;

public class Solution {

    public int storeWater(int[] bucket, int[] vat) {
        int days = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return bucket[a] * vat[b] - bucket[b] * vat[a];
        });
        int result = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (vat[i] == 0) {
                continue;
            }
            if (bucket[i] == 0) {
                bucket[i]++;
                days++;
            }
            int v = storeDays(vat[i], bucket[i]);
            result = result > v?  result : v;
            queue.add(i);
        }

        if (queue.isEmpty()) {
            return 0;
        }

        result = result + days;
        boolean change = true;
        while (change) {
            int index = queue.poll();
            int v = days + 1 + storeDays(vat[index], bucket[index] + 1);
            if (v <= result) {
                bucket[index]++;
                days++;
                queue.add(index);
                
                int n = queue.peek();
                int tmp = days + storeDays(vat[n], bucket[n]);
                if(tmp < result) {
                    result = tmp;
                }
            } else {
                change = false;
            }
        }

        return result;
    }

    private int storeDays(int a, int b) {
        if (a % b == 0) {
            return a / b;
        } else {
            return a / b + 1;
        }
    }

    public static void main(String args[]) {
        int[] bucket = {0};
        int[] vat = {2};
        Solution s = new Solution();
        System.out.println(s.storeWater(bucket, vat));
    }

}
