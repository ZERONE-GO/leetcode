package p0003;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int left = 0, right = 0;
        int result = 0;

        while (right < length) {
            int tmp = left;
            while (tmp < right) {
                if (s.charAt(tmp) != s.charAt(right)) {
                    tmp++;
                } else {
                    if (result < right - left) {
                        result = right - left;
                    }
                    left = tmp + 1;
                    break;
                }
            }

            right++;
        }

        if (result < right - left) {
            result = right - left;
        }

        return result;
    }
}
