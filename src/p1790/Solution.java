package p1790;

public class Solution {

    public boolean areAlmostEqual(String s1, String s2) {
        int i = 0;
        int count = 0;
        int[] error = new int[2];
        while (i < s1.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                } else {
                    error[count - 1] = i;
                }
            }
            i++;
        }

        if (count == 0) {
            return true;
        } else if (count == 1) {
            return false;
        } else {
            return s1.charAt(error[0]) == s2.charAt(error[1]) && s1.charAt(error[1]) == s2.charAt(error[0]);
        }
    }

}
