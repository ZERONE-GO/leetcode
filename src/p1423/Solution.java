package p1423;

public class Solution {

    public int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;
        int[] preSum = new int[length + 1];
        int[] suffixSum = new int[length + 1];

        for (int i = 0; i < length; i++) {
            preSum[i + 1] = preSum[i] + cardPoints[i];
            suffixSum[i + 1] = suffixSum[i] + cardPoints[length - i - 1];
        }

        if (k >= length) {
            return preSum[length];
        }

        int score = 0;

        for (int i = 0; i <= k; i++) {
            score = Math.max(score, preSum[i] + suffixSum[k - i]);
        }
        return score;
    }

}
