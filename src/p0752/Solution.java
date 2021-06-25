package p0752;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int openLock(String[] deadends, String target) {
        int[] hash = new int[10000];

        for (int i = 0; i < deadends.length; i++) {
            hash[value(deadends[i])] = -1;
        }

        if (hash[0] == -1) {
            return -1;
        }
        int tv = value(target);
        if(tv == 0) {
            return 0;
        }
        List<Integer> path = new ArrayList<Integer>();
        path.add(0);
        for (int i = 0; i < path.size(); i++) {
            for(int j=0; j < 4; j ++) {
                int up = next(path.get(i), j, true);
                 if(up == tv) {
                    hash[up] = hash[path.get(i)] + 1;
                    return hash[up];
                } else if(hash[up] == 0) {
                    hash[up] = hash[path.get(i)] + 1;
                    path.add(up);
                }
                int down = next(path.get(i), j, false);
                if(down == tv) {
                    hash[down] = hash[path.get(i)] + 1;
                    return hash[down];
                } else if(hash[down] ==0){
                    hash[down] = hash[path.get(i)] + 1;
                    path.add(down);
                }
            }
        }

        return -1;
    }

    private int next(int num, int bit, boolean up) {
        int[] arr = new int[4];

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = num % 10;
            num = num / 10;
        }

        if (up) {
            arr[bit] = arr[bit] == 9 ? 0 : arr[bit] + 1;
        } else {
            arr[bit] = arr[bit] == 0 ? 9 : arr[bit] - 1;
        }

        int v = 0;

        for (int i = 0; i < arr.length; i++) {
            v = v * 10 + arr[i];
        }

        return v;
    }

    private int value(String code) {
        int v = 0;

        for (int i = 0; i < code.length(); i++) {
            v = v * 10 + code.charAt(i) - '0';
        }
        return v;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(s.openLock(deadends, target));
    }
}
