package p1442;

public class Solution {

    public int countTriplets(int[] arr) {
        int ans = 0;
        int a = 0, b = 0;

        for (int i = 0; i < arr.length; i++) {
            a = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    b = b ^ arr[k];
                    if (a == b) {
                        ans++;
                    }
                }
                a = a ^ arr[j];
                b = 0;
            }
        }
        return ans;
    }

}
