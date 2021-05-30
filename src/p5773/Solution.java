package p5773;

class Solution {
    public String maxValue(String n, int x) {
        boolean minus = isMinus(n.charAt(0));
        StringBuilder sb = new StringBuilder();

        if (minus) {
            sb.append("-");
            int i = 1;
            while (i < n.length() && toNum(n.charAt(i)) <= x) {
                sb.append(n.charAt(i));
                i++;
            }
            sb.append(toChar(x));
            while (i < n.length()) {
                sb.append(n.charAt(i));
                i++;
            }
        } else {
            int i = 0;
            while (i < n.length() && toNum(n.charAt(i)) >= x) {
                sb.append(n.charAt(i));
                i++;
            }
            sb.append(toChar(x));
            while (i < n.length()) {
                sb.append(n.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }

    private boolean isMinus(char c) {
        return c == '-';
    }

    private char toChar(int x) {
        return (char) ('0' + x);
    }

    private int toNum(char c) {
        return c - '0';
    }
}