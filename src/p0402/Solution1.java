package p0402;

class Solution1 {
    public String removeKdigits(String num, int k) {
        int length = num.length();
        if (length <= k) {
            return "0";
        }

        int[] arr = new int[length - k + 1];
        arr[0] = -1;
        for(int i=1; i < arr.length; i ++) {
            arr[i] = findMin(num, arr[i-1] + 1, k + i - 1);
        }
        
        int i = 1;
        for(; i < arr.length; i ++) {
            if(num.charAt(arr[i]) != '0') {
                break;
            }
        }
        String result = "";
        for(; i < arr.length; i ++) {
            result += num.charAt(arr[i]);
        }
        return result == "" ? "0" : result;
    }
    
    private int findMin(String num, int start, int end) {
        int v = num.charAt(start), index = start;
        for(int i= start + 1; i <= end; i ++) {
            if(v > num.charAt(i)) {
                v = num.charAt(i);
                index = i;
            }
        }
        return index;
    }
}
