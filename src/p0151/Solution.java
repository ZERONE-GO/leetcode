package p0151;

class Solution {
    public String reverseWords(String s) {
        char[] reverse = new char[s.length()];
        int len = 0;
        int ws = s.length() - 1, we = s.length() - 1;

        while (ws >= 0) {
            if (s.charAt(ws) == ' ') {
                if (ws < we) {
                    int tmp = ws + 1;
                    if(len > 0) {
                        reverse[len++] = ' ';
                    }
                    while (tmp <= we) {
                        reverse[len++] = s.charAt(tmp++);
                    }
                }
                we = ws - 1;
            }

            ws--;
        }
        
        if (ws < we) {
            int tmp = ws + 1;
            if(len > 0) {
                reverse[len++] = ' ';
            }
            while (tmp <= we) {
                reverse[len++] = s.charAt(tmp++);
            }
        }

        return new String(reverse).trim();
    }
}
