package p5772;

public class Solution {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return toNum(firstWord) + toNum(secondWord) == toNum(targetWord);
    }

    private int toNum(String word) {
        int num = 0;

        for (int i = 0; i < word.length(); i++) {
            num = num * 10 + value(word.charAt(i));
        }
        return num;
    }

    private int value(char c) {
        return c - 'a';
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.isSumEqual("j", "j", "bi"));
    }
}
