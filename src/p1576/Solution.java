package p1576;

public class Solution {
    
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i < s.length(); i ++) {
            if(s.charAt(i) != '?') {
                sb.append(s.charAt(i));
            } else {
                char c1 = i > 0 ? sb.charAt(i-1) : ' ';
                char c2 = i < s.length() - 1 ? s.charAt(i+1) : ' ';
                sb.append(replaceChar(c1, c2));
            }
        }
        return sb.toString();
    }
    
    private char replaceChar(char c1, char c2) {
        char c = 'a';
        while(c == c1 || c == c2) {
            c ++;
        }
        return c;
    }

}
