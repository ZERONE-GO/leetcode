package p0767;

import java.util.PriorityQueue;

public class Solution {

    public String reorganizeString(String S) {
        int[] count = new int[26];

        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'a']++;
        }

        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> {
            return count[b - 'a'] - count[a - 'a'];
        });
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                queue.offer((char) ('a' + i));
            }
        }

        char[] result = new char[S.length()];
        int rl = 0;
        while (queue.size() >= 2) {
            char a = queue.poll();
            char b = queue.poll();

            while (count[a - 'a'] != 0 && count[b - 'a'] != 0) {
                result[rl++] = a;
                result[rl++] = b;
                count[a - 'a']--;
                count[b - 'a']--;
            }

            if (count[a - 'a'] > 0) {
                queue.offer(a);
            }
        }

        if (!queue.isEmpty()) {
            char a = queue.poll();
            if (count[a - 'a'] > 1) {
                return "";
            } else {
                result[rl] = a;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        Solution s = new Solution();

        System.out.println(s.reorganizeString("aaab"));
        System.out.println(s.reorganizeString("aab"));
    }

}
