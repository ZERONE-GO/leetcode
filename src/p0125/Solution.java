package p0125;

public class Solution {

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (!isCharacterOrNum(s.charAt(left)) && left < right) {
                left++;
            }

            while (!isCharacterOrNum(s.charAt(right)) && right > left) {
                right--;
            }

            if (value(s.charAt(left)) == value(s.charAt(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    private int value(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 'a';
        } else {
            return c;
        }
    }

    private boolean isCharacterOrNum(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
