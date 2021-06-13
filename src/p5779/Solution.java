package p5779;

import java.util.Arrays;

public class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        int n = packages.length;

        long res = -1;
        for (int i = 0; i < boxes.length; i++) {
            Arrays.sort(boxes[i]);
            int len = boxes[i].length;
            if (boxes[i][len - 1] >= packages[n - 1]) {
                long tmp = 0;
                for (int j = 0; j < n; j++) {
                    int index = Arrays.binarySearch(boxes[i], packages[j]);
                    if(index < 0) {
                        index = -index - 1;
                    }
                    tmp += boxes[i][index] - packages[j];
                }
                if(res == -1 || res > tmp) {
                    res = tmp;
                }
            }
        }
        return (int)(res % 1000000007);
    }
}
