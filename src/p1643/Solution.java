package p1643;

public class Solution {
    
    public String kthSmallestPath(int[] destination, int k) {
        int n = destination[0];
        int m = destination[1];
        
        int[] vp =new int[n];
        int l = 0;
        int pre = m+n;
        while(n > 0) {
            pre = bs(n, pre, n, k);
            
            vp[l] = pre + 1;
            l ++;
            k = k - (int)nCr(pre, n);
            n --;
        }
        
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i=destination[0] + destination[1]; i >= 1; i --) {
            if(j < l && i == vp[j]) {
                sb.append("V");
                j ++;
            } else {
                sb.append("H");
            }
        }
        return sb.toString();
    }
    
    private int bs(int left, int right, int n, int k) {
        while(left <= right) {
            int middle = (left + right) / 2;
            if(nCr(middle, n) < k) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return right;
    }
    
    private long nCr(long m, int n) {
        long res = 1;
        for(int i=1; i <= n; i ++) {
            res = res * (m - i + 1) / i;
        }
        return res;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        int[] destination = {15, 15};
//        System.out.println(s.kthSmallestPath(destination, 1));
//        System.out.println(s.kthSmallestPath(destination, 2));
//        System.out.println(s.kthSmallestPath(destination, 3));
//        System.out.println(s.kthSmallestPath(destination, 4));
//        System.out.println(s.kthSmallestPath(destination, 5));
//        System.out.println(s.kthSmallestPath(destination, 6));
//        System.out.println(s.kthSmallestPath(destination, 7));
//        System.out.println(s.kthSmallestPath(destination, 8));
//        System.out.println(s.kthSmallestPath(destination, 9));
//        System.out.println(s.kthSmallestPath(destination, 10));
        System.out.println(s.kthSmallestPath(destination, 155117520));
    }

}
