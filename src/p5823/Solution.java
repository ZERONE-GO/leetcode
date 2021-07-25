package p5823;

class Solution {
    public int getLucky(String s, int k) {
        int len = s.length();
        int[] stack = new int[len];
        
        
        for(int i=0; i < len; i ++) {
            stack[i] = s.charAt(i) - 'a' + 1;
        }
        
        int res = 0;
        int n = 1;
        for(int i=0; i < len ; i ++) {
            res = addNum(res, stack[i]);
        }
        
        while(n < k) {
            int tmp = addNum(0, res);
            res = tmp;
            n ++;
        }
        
        return res;
    }
    
    private int addNum(int res, int num) {
        while(num > 0) {
            res += num % 10;
            num = num / 10;
        }
        
        return res;
    }
    
    
}
