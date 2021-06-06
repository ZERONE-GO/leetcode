package p1876;

public class Solution {
    
    public int countGoodSubstrings(String s) {
        int count =0; 
        int left = 0, middle = 1, right = 2;
        
        while(right < s.length()) {
            if(s.charAt(left) != s.charAt(middle) && s.charAt(left) != s.charAt(right) && s.charAt(middle) != s.charAt(right)) {
                count ++;
            }
            left ++;
            middle ++;
            right ++;
        }
        
        return count;
    }
}
