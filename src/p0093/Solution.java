package p0093;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<String> res;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<String>();
        int[] phase = new int[4];
        restore(s, 0, 1, phase);
        return res;
    }

    private void restore(String s, int i, int step, int[] phase) {
        if (i >= s.length()) {
            return;
        }
        if (step == 4) {
            if (validIp(s, i, s.length() - 1)) {
                StringBuilder sb = new StringBuilder();
                for (int j = 1; j < 4; j++) {
                    sb.append(s.substring(phase[j - 1], phase[j])).append(".");
                }
                sb.append(s.substring(i));
                res.add(sb.toString());
            }
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (validIp(s, i, j)) {
                phase[step] = j + 1;
                restore(s, j + 1, step + 1, phase);
            } else {
                break;
            }
        }
    }

    private boolean validIp(String s, int l, int r) {
        if (l < r && s.charAt(l) == '0') {
            return false;
        }

        int d = 0;
        for (int i = l; i <= r; i++) {
            d = d * 10 + s.charAt(i) - '0';
            if(d > 255) {
                return false;
            }
        }
        return d <= 255;
    }
}
