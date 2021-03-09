package p0997;

public class Solution {

    public int findJudge(int N, int[][] trust) {
        int[] trusted = new int[N + 1];
        int[] trusting = new int[N + 1];

        for (int i = 0; i < trust.length; i++) {
            trusted[trust[i][1]]++;
            trusting[trust[i][0]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (trusted[i] == N - 1 && trusting[i] == 0) {
                return i;
            }
        }

        return -1;
    }

}
