package p5781;

public class Solution {

    public String removeOccurrences(String s, String part) {
        String res = s;
        while (res.indexOf(part) >= 0) {
            res = res.replaceAll(part, "");
        }

        return res;
    }
}
