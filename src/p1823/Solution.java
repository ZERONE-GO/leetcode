package p1823;

public class Solution {

    public int findTheWinner(int n, int k) {
        int[] map = new int[n];
        
        int j = 0;
        for(int i=0; i < n-1; i ++) {
            int tmp = 0;
            while(tmp < k) {
                if(map[j] == 0) {
                    tmp ++;
                    if(tmp == k) {
                        map[j] = -1;
                    }
                }
                j = (j+1) % n;
            }
            while(map[j] !=0) {
                j = (j+1) % n;
            }
        }
        
        int result = 0;
        for(int i=0; i < n; i ++) {
            if(map[i] == 0) {
                return i+1;
            }
        }
        return result;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        s.findTheWinner(5, 2);
    }
}
