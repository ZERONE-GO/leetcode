package p5740;

public class Solution {

    public int longestBeautifulSubstring(String word) {
        int left = 0, right = 0;
        int status = 0;
        int max = 0;
        while (right < word.length()) {
            if (status == 0) {
                if (word.charAt(right) == 'a') {
                    right++;
                    status = 1;
                } else {
                    right++;
                    left = right;
                    status = 0;
                }
            } else if (status == 1) {
                if (word.charAt(right) == 'a') {
                    right++;
                } else if (word.charAt(right) == 'e') {
                    right++;
                    status = 2;
                } else {
                    right++;
                    left = right;
                    status = 0;
                }
            } else if (status == 2) {
                if (word.charAt(right) == 'e') {
                    right++;
                } else if (word.charAt(right) == 'i') {
                    right++;
                    status = 3;
                } else {
                    left = right;
                    status = 0;
                }
            } else if (status == 3) {
                if (word.charAt(right) == 'i') {
                    right++;
                } else if (word.charAt(right) == 'o') {
                    right++;
                    status = 4;
                } else {
                    left = right;
                    status = 0;
                }
            } else if (status == 4) {
                if (word.charAt(right) == 'o') {
                    right++;
                } else if (word.charAt(right) == 'u') {
                    right++;
                    status = 5;
                } else {
                    left = right;
                    status = 0;
                }
            } else if (status == 5) {
                if (word.charAt(right) == 'u') {
                    right++;
                } else {
                    if (max < right - left) {
                        max = right - left;
                    }
                    left = right;
                    status = 0;
                }
            }
        }

        if (status == 5) {
            if (max < right - left) {
                max = right - left;
            }
        }

        return max;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.longestBeautifulSubstring("auoeioueiaaioeuieuoaieuaoeuoaiaoueioiaeuiuaeouaoie"));
    }

}
