package p0402;

public class Solution {

    public String removeKdigits(String num, int k) {
        if (num.length() <= 0) {
            return "0";
        }

        char[] digitStack = new char[num.length()];
        int dl = 0;

        for (int i = 0; i < num.length(); i++) {
            if (dl == 0) {
                digitStack[dl++] = num.charAt(i);
            } else if (digitStack[dl - 1] <= num.charAt(i)) {
                digitStack[dl++] = num.charAt(i);
            } else {
                while (k > 0 && dl > 0 && digitStack[dl - 1] > num.charAt(i)) {
                    dl--;
                    k--;
                }
                digitStack[dl++] = num.charAt(i);
            }
        }
        dl = dl - k;
        if (dl == 0) {
            return "0";
        }

        // remove zero prefix
        int i = 0;
        while (i < dl && digitStack[i] == '0') {
            i++;
        }
        String result = "";
        for (; i < dl; i++) {
            result += digitStack[i];
        }
        return result == "" ? "0" : result;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.removeKdigits("0", 0));
    }

}
