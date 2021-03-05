package p0067;

public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int prefix = 0;
        int al = a.length() - 1, bl = b.length() - 1;
        
        int a1, b1, s1;

        while (al >= 0 && bl >= 0) {
            a1 = a.charAt(al) - '0';
            b1 = b.charAt(bl) - '0';

            s1 = a1 + b1 + prefix;
            sb.append(s1 % 2);
            prefix = s1 / 2;
            al--;
            bl--;
        }

        while (al >= 0) {
            a1 = a.charAt(al) - '0';
            s1 = a1 + prefix;
            sb.append(s1 % 2);
            prefix = s1 / 2;
            al--;
        }

        while (bl >= 0) {
            b1 = b.charAt(bl) - '0';
            s1 = b1 + prefix;
            sb.append(s1 % 2);
            prefix = s1 / 2;
            bl--;
        }

        if (prefix != 0) {
            sb.append(prefix);
        }
        return sb.reverse().toString();
    }

}
