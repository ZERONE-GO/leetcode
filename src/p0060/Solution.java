package p0060;

public class Solution {

    public String getPermutation(int n, int k) {
        int size = 1;

        for (int i = 1; i < n; i++) {
            size = size * i;
        }

        StringBuilder sb = new StringBuilder();
        int[] map = new int[n];
        for (int i = 1; i <= n; i++) {
            int v = (k - 1) / size;
            int tmp = v;
            for (int j = 0; j < n; j++) {
                if (map[j] == 0) {
                    v--;
                    if (v < 0) {
                        map[j] = i;
                        sb.append(j + 1);
                        break;
                    }
                }
            }
            k = k - tmp * size;
            if(n-i !=0) {
                size = size / (n - i);
            }
        }

        return sb.toString();
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.getPermutation(9, 3));
    }

}
