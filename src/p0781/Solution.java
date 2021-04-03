package p0781;

import java.util.Arrays;

public class Solution {

    public int numRabbits(int[] answers) {
        if (answers.length == 0) {
            return 0;
        }
        Arrays.sort(answers);

        int result = 0;
        int count = 1, base = answers[0] + 1;

        for (int i = 1; i < answers.length; i++) {
            if (answers[i] == answers[i - 1]) {
                count++;
            } else {
                while(count > 0) {
                    result += base;
                    count -= base;
                }
                base = answers[i] + 1;
                count = 1;
            }
        }

        while(count > 0) {
            result += base;
            count -= base;
        }
        return result;
    }

}
