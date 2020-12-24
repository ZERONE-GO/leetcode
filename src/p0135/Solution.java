package p0135;

public class Solution {

    public int candy(int[] ratings) {
        int[] count = new int[ratings.length];

        count[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            } else {
                count[i] = 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                count[i] = Math.max(count[i], count[i + 1] + 1);
            }
        }

        int result = 0;
        for (int i = 0; i < ratings.length; i++) {
            result += count[i];
        }

        return result;
    }

}
