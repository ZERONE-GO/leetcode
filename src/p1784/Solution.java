package p1784;

public class Solution {

    public boolean checkOnesSegment(String s) {
        int index = 0;
        while (index < s.length() && s.charAt(index) == '1') {
            index++;
        }

        while (index < s.length() && s.charAt(index) == '0') {
            index++;
        }

        return index == s.length();
    }
}
