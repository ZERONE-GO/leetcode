package p5824;

class Solution {
    public String maximumNumber(String num, int[] change) {
        int len = num.length();
        int[] res = new int[len];

        int status = 0;
        for (int i = 0; i < len; i++) {
            int bit = num.charAt(i) - '0';

            if (bit < change[bit]) {
                if (status == 0 || status == 1) {
                    res[i] = change[bit];
                    status = 1;
                } else {
                    res[i] = bit;
                }
            } else if (bit == change[bit]) {
                res[i] = bit;
            } else {
                res[i] = bit;
                if (status == 1) {
                    status = 2;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(res[i]);
        }

        return sb.toString();
    }
}
