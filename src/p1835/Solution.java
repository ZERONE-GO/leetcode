package p1835;

public class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {

        int xor = 0;

        for (int i = 0; i < arr2.length; i++) {
            xor = xor ^ arr2[i];
        }

        int result = 0;
        for (int i = 0; i < arr1.length; i++) {
            result = result ^ (arr1[i] & xor);
        }
        return result;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        int[] arr1 = {12};
        int[] arr2 = {4};
        
        s.getXORSum(arr1, arr2);
    }
}