package o0038;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String[] permutation(String s) {
        List<String> res = new ArrayList<String>();

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        res.add(String.valueOf(arr));

        while(nextPermutation(arr)) {
            res.add(String.valueOf(arr));
        }

        int size = res.size();
        String[] recArr = new String[size];
        for (int i = 0; i < size; i++) {
            recArr[i] = res.get(i);
        }
        return recArr;
    }

    private boolean nextPermutation(char[] arr) {
        int idx = arr.length - 2;
        while (idx >= 0 && arr[idx] >= arr[idx + 1]) {
            idx--;
        }

        if (idx < 0) {
            return false;
        }

        int nxt = idx + 1, i = idx + 1;

        while (i < arr.length) {
            if (arr[i] > arr[idx] && arr[i] < arr[nxt]) {
                nxt = i;
            }
            i++;
        }

        swap(arr, idx, nxt);
        Arrays.sort(arr, idx + 1, arr.length);

        return true;
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    

    public static void main(String args[]) {
        Solution s = new Solution();
        String[] strs = s.permutation("kzfxxx");
        for (String str : strs) {
            System.out.println(str);
        }
    }

}