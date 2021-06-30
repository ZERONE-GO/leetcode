package p1255;

public class Solution {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];
        for (int i = 0; i < letters.length; i++) {
            count[letters[i] - 'a']++;
        }

        int ans = 0;
        for (int i = 0; i < (1 << words.length); i++) {
            int[] used = countLetter(words, i);
            int s = score(used, score, count);
            ans = ans > s ? ans : s;
        }

        return ans;
    }

    private int score(int[] used, int[] score, int[] count) {
        int s = 0;

        for (int i = 0; i < 26; i++) {
            if (used[i] > count[i]) {
                return 0;
            } else {
                s = s + used[i] * score[i];
            }
        }

        return s;
    }

    private int[] countLetter(String[] words, int bits) {
        int[] letters = new int[26];

        for (int i = 0; i < words.length; i++) {
            if ((bits & (1 << i)) != 0) {
                for (int j = 0; j < words[i].length(); j++) {
                    letters[words[i].charAt(j) - 'a']++;
                }
            }
        }
        return letters;
    }

    public static void main(String args[]) {
        String[] words = { "dog", "cat", "dad", "good" };
        char[] letters = { 'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o' };
        int[] score = { 1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        Solution s = new Solution();
        s.maxScoreWords(words, letters, score);
    }

}
