package p0976;

import java.util.Arrays;

public class Solution {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);

        int largest = 0;
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                largest = A[i] + A[i - 1] + A[i - 2];
                break;
            }
        }

        return largest;
    }

}
