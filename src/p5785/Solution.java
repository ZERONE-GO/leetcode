package p5785;

public class Solution {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] merge = new int[3];

        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]) {
                merge[0] = Math.max(merge[0], triplets[i][0]);
                merge[1] = Math.max(merge[1], triplets[i][1]);
                merge[2] = Math.max(merge[2], triplets[i][2]);
            }
        }

        return merge[0] == target[0] && merge[1] == target[1] && merge[2] == target[2];
    }

}
