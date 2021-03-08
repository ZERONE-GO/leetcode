package p0131;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {
        Object[][] map = new Object[s.length()][s.length()];
        return palindromic(s, 0, s.length() - 1, map);
    }

    private List<List<String>> palindromic(String str, int s, int e, Object[][] map) {
        List<List<String>> result = new ArrayList<List<String>>();

        if (s > e) {
            return result;
        }

        for (int i = s; i <= e; i++) {
            if (isPalindromic(str, s, i)) {
                String left = str.substring(s, i + 1);
                if (i == e) {
                    List<String> row = new ArrayList<String>();
                    row.add(left);
                    result.add(row);
                } else {
                    List<List<String>> right ;
                    if(map[i+1][e] != null) {
                        right = (List<List<String>>)map[i+1][e];
                    } else {
                        right = palindromic(str, i + 1, e, map);
                        map[i+1][e] = right;
                    }
                    for (int k = 0; k < right.size(); k++) {
                        List<String> row = new ArrayList<String>();
                        row.add(left);
                        row.addAll(right.get(k));
                        result.add(row);
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindromic(String str, int s, int e) {
        while (s <= e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        List<List<String>> result = s.partition("aab");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
