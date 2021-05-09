package p5750;

public class Solution {
    private static final int START = 1950;

    public int maximumPopulation(int[][] logs) {
        int[] years = new int[101];

        for (int i = 0; i < logs.length; i++) {
            for (int j = logs[i][0]; j < logs[i][1]; j++) {
                years[j - START]++;
            }
        }

        int max = 0;
        int year = 0;
        for (int i = 0; i < years.length; i++) {
            if (max < years[i]) {
                max = years[i];
                year = i;
            }
        }
        return year + START;
    }
}
