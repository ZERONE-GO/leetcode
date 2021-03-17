package p1346;

import java.util.Arrays;

public class Solution {

    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int N = 2 * arr[i];
            int index = Arrays.binarySearch(arr, N);
            if (N == 0) {
                if (index != i) {
                    return true;
                } else {
                    if ((index > 0 && arr[index - 1] == 0) || (index < arr.length - 1 && arr[index + 1] == 0)) {
                        return true;
                    }
                }
            }
            if (index >= 0 && index != i) {
                return true;
            }
        }

        return false;
    }

}
