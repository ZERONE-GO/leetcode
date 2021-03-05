package p0077;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>(k);
        walk(path, 1, 1, n, k);

        return result;
    }

    private void walk(List<Integer> list, int step, int v, int n, int k) {
        if (step > k) {
            List<Integer> nl = new ArrayList<Integer>(k);
            nl.addAll(list);
            result.add(nl);
            return;
        }

        
        for (int i = v; i <= n - k + step; i++) {
            if(list.size() < step) {
                list.add(i);
            } else {
                list.set(step - 1, i);
            }
            walk(list, step + 1, i + 1, n, k);
        }
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        s.combine(4, 2);
    }

}
