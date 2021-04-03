package p5706;

public class Solution {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        return sentence1.length() < sentence2.length() ? similar(sentence1, sentence2) : similar(sentence2, sentence1);
    }

    private boolean similar(String s1, String s2) {
        int left = 0, right = 0;
        
        while(right < s1.length()) {
            if(s1.charAt(right) == s2.charAt(right)) {
                if(s1.charAt(right) == ' ') {
                    left = right;
                }
                right ++;
            } else {
                break;
            }
        }
        
        if(right >= s1.length() && (right >= s2.length() || s2.charAt(right) == ' ')) {
            return true;
        }
        
        if(left == 0) {
            if(s2.charAt(s2.length() - s1.length() -1) != ' ') {
                return false;
            }
        }
        int s2i = s2.length() - s1.length() + left;
        while(s2i < s2.length()) {
            if(s2.charAt(s2i) == s1.charAt(left)) {
                s2i ++;
                left ++;
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
//        System.out.println(s.areSentencesSimilar("My name is Haley", "My Haley"));
//        System.out.println(s.areSentencesSimilar("Eatinggg", "Eating"));
//        System.out.println(s.areSentencesSimilar("Eating", "Eating Right NOw"));
//        System.out.println(s.areSentencesSimilar("Eating", "aa Eating"));
//        System.out.println(s.areSentencesSimilar("a c", "a c"));
        System.out.println(s.areSentencesSimilar("ac", "acc dc d d ca cac"));
    }
}
