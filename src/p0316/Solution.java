package p0316;

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        boolean[] flag = new boolean[26];
        char[] stack = new char[26];
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (flag[s.charAt(i) - 'a']) {
                count[s.charAt(i) - 'a']--;
                continue;
            }
            if (l == 0 || s.charAt(i) > stack[l - 1]) {
                stack[l] = s.charAt(i);
                flag[s.charAt(i) - 'a'] = true;
                l++;
            } else {
                while (l > 0 && s.charAt(i) <= stack[l - 1] && count[stack[l - 1] - 'a'] > 0) {
                    flag[stack[l - 1] - 'a'] = false;
                    l--;
                }
                stack[l] = s.charAt(i);
                flag[s.charAt(i) - 'a'] = true;
                l++;
            }
            count[s.charAt(i) - 'a']--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l; i++) {
            sb.append(stack[i]);
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicateLetters("abacb"));
        System.out.println(s.removeDuplicateLetters("bcabc"));
        System.out.println(s.removeDuplicateLetters("cbacdcbc"));
    }
}
