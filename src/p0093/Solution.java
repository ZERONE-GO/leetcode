package p0093;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<String> res;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<String>();
        int[] phase = new int[4];
        restore(s, 0, phase, 1);
        return res;
    }

    private void restore(String s, int index, int[] phase, int step) {
        if (index >= s.length()) {
            return;
        }

        if (step == 4) {
            int ip = toIp(s, index, s.length() - 1);
            if (ip >= 0 && ip <= 255) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    sb.append(phase[i]).append(".");
                }
                sb.append(ip);
                res.add(sb.toString());
            }
            return;
        }

        for (int i = index; i < s.length(); i++) {
            int ip = toIp(s, index, i);
            if (ip >= 0 && ip <= 255) {
                phase[step-1] = ip;
                restore(s, i + 1, phase, step + 1);
            } else {
                break;
            }
        }

    }

    private int toIp(String s, int left, int right) {
        if (left < right && s.charAt(left) == '0') {
            return -1;
        }

        if (right - left > 2) {
            return -1;
        }

        int ip = 0;
        for (int i = left; i <= right; i++) {
            ip = ip * 10 + s.charAt(i) - '0';
        }
        return ip;
    }
}
