package p0205;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> dict = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = dict.get(t.charAt(i));
            if (c == null) {
                dict.put(t.charAt(i), s.charAt(i));
            } else if(c != s.charAt(i)) {
                return false;
            } 
        }
        
        dict.clear();
        for (int i = 0; i < s.length(); i++) {
            Character c = dict.get(s.charAt(i));
            if (c == null) {
                dict.put(s.charAt(i), t.charAt(i));
            } else if(c != t.charAt(i)) {
                return false;
            } 
        }
        
        return true;
    }
    
    public static void main(String args[]) {
        Solution S = new Solution();
        System.out.println(S.isIsomorphic("ab", "ca"));
        System.out.println(S.isIsomorphic("egg", "foo"));
        System.out.println(S.isIsomorphic("foo", "bar"));
        System.out.println(S.isIsomorphic("paper", "title"));
    }

}
