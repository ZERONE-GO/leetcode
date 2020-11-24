package p0020;

public class Solution {

    public boolean isValid(String s) {
        char[] bracketStack = new char[s.length()];
        int bl = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                bracketStack[bl++] = s.charAt(i);
            } else if (s.charAt(i) == ')') {
                if(bl > 0 && bracketStack[bl-1] == '(') {
                    bl --;
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if(bl > 0 && bracketStack[bl-1] == '[') {
                    bl --;
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if(bl > 0 && bracketStack[bl-1] == '{') {
                    bl --;
                } else {
                    return false;
                }
            }
        }

        return bl == 0;
    }

}
