package p0978;

public class Solution {

    public int maxTurbulenceSize(int[] arr) {
        int mode1 = count(arr, true);
        int mode2 = count(arr, false);

        return mode1 > mode2 ? mode1 : mode2;
    }

    private int count(int[] arr, boolean flag) {
        int result = 1;
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (flag) {
                if (arr[i] > arr[i + 1]) {
                    count++;
                } else {
                    result = result < count ? count : result;
                    count = 1;
                }
            } else {
                if(arr[i] < arr[i+1]) {
                    count ++;
                } else {
                    result = result < count ? count : result;
                    count = 1;
                }
            }

            flag = !flag;
        }
        result = result < count ? count : result;
        return result;
    }
}
