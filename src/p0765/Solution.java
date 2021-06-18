package p0765;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int minSwapsCouples(int[] row) {
        int[] users = new int[row.length];
        boolean[] color = new boolean[row.length];

        for (int i = 0; i < row.length; i++) {
            users[row[i]] = i;
        }

        int count = 0;
        for (int i = 0; i < row.length; i = i + 2) {
            if (!isCouple(users[i], users[i + 1]) && !color[i]) {
                List<Integer> pairs = new ArrayList<>();
                pairs.add(i);
                color[i] = true;

                for (int j = 0; j < pairs.size(); j++) {
                    int user = pairs.get(j);

                    if ((user & 1) == 1) {
                        if (!color[user - 1]) {
                            pairs.add(user - 1);
                            color[user - 1] = true;
                        }
                    } else {
                        if (!color[user + 1]) {
                            pairs.add(user + 1);
                            color[user + 1] = true;
                        }
                    }

                    int pos = users[user];
                    if ((pos & 1) == 1) {
                        if (!color[row[pos-1]]) {
                            pairs.add(row[pos-1]);
                            color[row[pos-1]] = true;
                        }
                    } else {
                        if (!color[row[pos + 1]]) {
                            pairs.add(row[pos + 1]);
                            color[row[pos + 1]] = true;
                        }
                    }
                }
                count += (pairs.size() / 2 - 1);
            } else {
                color[i] = color[i + 1] = true;
            }
        }
        return count;
    }

    private boolean isCouple(int a, int b) {
        if ((a & 1) != 1) {
            return b == a + 1;
        } else if ((b & 1) != 1) {
            return a == b + 1;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int[] row = { 5, 4, 2, 6, 3, 1, 0, 7 };
        System.out.println(s.minSwapsCouples(row));
    }

}
