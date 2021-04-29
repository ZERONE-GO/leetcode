package lcp023;

class Solution {
    public boolean isMagic(int[] target) {
        if (target.length == 1) {
            return true;
        }

        int k = 0;
        while (target[k] == 2 * (k + 1)) {
            k++;
        }

        if (k == 0) {
            return false;
        }

        if (target[k - 1] == target.length || target[k - 1] == target.length - 1) {
            int i = 0;
            while (k < target.length && target[k] == 2 * i + 1) {
                k++;
                i++;
            }
        }

        int[] arr = new int[target.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        int t = 0;
        while (t * k < target.length) {
            mock(arr, t, k);

            for (int i = t * k; i < Math.min(t * k + k, target.length); i++) {
                if (arr[i] != target[i]) {
                    return false;
                }
            }

            t++;
        }
        return true;
    }

    private void mock(int[] arr, int t, int k) {
        int s = t * k, left = s, right = s + 1;

        while (right < arr.length) {
            if (((right - s) & 1) == 1) {
                for (int i = right; i > left; i--) {
                    int tmp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = tmp;
                }
                left++;
            }
            right++;
        }
    }
    
    public static void main(String args[]) {
        int[] target = {2 ,4, 1, 3 ,5};
        Solution s = new Solution();
        s.isMagic(target);
    }
}
