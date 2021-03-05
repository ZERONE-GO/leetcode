package p0017;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static char[][] dict = new char[8][];
    static {
        dict[0] = new char[] { 'a', 'b', 'c' };
        dict[1] = new char[] { 'd', 'e', 'f' };
        dict[2] = new char[] { 'g', 'h', 'i' };
        dict[3] = new char[] { 'j', 'k', 'l' };
        dict[4] = new char[] { 'm', 'n', 'o' };
        dict[5] = new char[] { 'p', 'q', 'r', 's' };
        dict[6] = new char[] { 't', 'u', 'v' };
        dict[7] = new char[] { 'w', 'x', 'y', 'z' };
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();

        if (digits == null || digits.equals("")) {
            return result;
        }

        char[] letter = new char[digits.length()];
        combination(digits, 0, digits.length(), letter, result);
        return result;
    }

    private void combination(String digits, int index, int length, char[] letter, List<String> result) {
        if (index >= length) {
            String l = "";
            for (int i = 0; i < length; i++) {
                l += letter[i];
            }
            result.add(l);
            return;
        }
        int digit = digits.charAt(index) - '2';
        for (int i = 0; i < dict[digit].length; i++) {
            letter[index] = dict[digit][i];
            combination(digits, index + 1, length, letter, result);
        }
    }
}