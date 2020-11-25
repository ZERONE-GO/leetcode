package p0409;

class Solution {
    public int longestPalindrome(String s) {
        int cnt[] = new int[128];

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)]++;
        }
        int result = 0;
        boolean odd = false;
        for (int i = 0; i < cnt.length; i++) {
            if ((cnt[i] & 1) == 1) {
                result = result + cnt[i] - 1;
                odd = true;
            } else {
                result = result + cnt[i];
            }
        }

        return odd ? result + 1 : result;
    }
}
