package lcp029;

public class Solution {

    public int orchestraLayout(int num, int xPos, int yPos) {
        int n = Math.min(xPos, Math.min(num - xPos - 1, Math.min(yPos, num - yPos - 1)));
        int result = size(num, n);
        
        // top
        if(xPos == n) {
            result = (result + yPos - n) % 9;
            return result + 1;
        }
        result = (result + num - 2 * n - 1) % 9;
        //right
        if(yPos == num - n - 1) {
            result = (result + xPos - n) % 9;
            return result + 1;
        }
        result = (result + num -2 *n -1) % 9;
        //down
        if(xPos == num -n -1) {
            result = (result + num - n - 1 - yPos) % 9;
            return result + 1;
        }
        result = (result + num - 2 * n - 1) % 9;
        //left 
        result = (result + num -n -1 - xPos) % 9;
        return result + 1;
    }
    
    private int size(int n, int tmp) {
        int tm = tmp % 9;
        int nm = n % 9;
        return (4 * (tm *nm % 9 + (9 - tm * tm % 9))) % 9;
    }
//    public int orchestraLayout(int num, int xPos, int yPos) {
//        int n = Math.min(xPos, Math.min(num - xPos - 1, Math.min(yPos, num - yPos - 1)));
//        int result = 0;
//        int tmp = 0;
//        while(tmp < n) {
//            result = (result + size(num - tmp * 2)) % 9; 
//            tmp ++;
//        }
//        
//        // top
//        if(xPos == n) {
//            result = (result + yPos - n) % 9;
//            return result + 1;
//        }
//        result = (result + num - 2 * n - 1) % 9;
//        //right
//        if(yPos == num - n - 1) {
//            result = (result + xPos - n) % 9;
//            return result + 1;
//        }
//        result = (result + num -2 *n -1) % 9;
//        //down
//        if(xPos == num -n -1) {
//            result = (result + num - n - 1 - yPos) % 9;
//            return result + 1;
//        }
//        result = (result + num - 2 * n - 1) % 9;
//        //left 
//        result = (result + num -n -1 - xPos) % 9;
//        return result + 1;
//    }
//    
//    private int size(int n) {
//        return (n % 9 + n % 9 + n % 9 + n % 9 + 5) % 9;
//    }    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.orchestraLayout(5, 0, 0));
        System.out.println(s.orchestraLayout(5, 0, 1));
        System.out.println(s.orchestraLayout(5, 0, 2));
        System.out.println(s.orchestraLayout(5, 0, 3));
        System.out.println(s.orchestraLayout(5, 0, 4));
        System.out.println(s.orchestraLayout(5, 1, 4));
        System.out.println(s.orchestraLayout(5, 2, 4));
        System.out.println(s.orchestraLayout(5, 3, 4));
        System.out.println(s.orchestraLayout(5, 4, 4));
        System.out.println(s.orchestraLayout(5, 4, 3));
        System.out.println(s.orchestraLayout(5, 4, 2));
        System.out.println(s.orchestraLayout(5, 4, 1));
        System.out.println(s.orchestraLayout(5, 4, 0));
        System.out.println(s.orchestraLayout(5, 3, 0));
        System.out.println(s.orchestraLayout(5, 2, 0));
        System.out.println(s.orchestraLayout(5, 1, 0));
        System.out.println(s.orchestraLayout(5, 1, 1));
        System.out.println(s.orchestraLayout(5, 1, 2));
        System.out.println(s.orchestraLayout(5, 1, 3));
        System.out.println(s.orchestraLayout(5, 2, 3));
        System.out.println(s.orchestraLayout(5, 3, 3));
        System.out.println(s.orchestraLayout(5, 3, 2));
        System.out.println(s.orchestraLayout(5, 3, 1));
        System.out.println(s.orchestraLayout(5, 2, 1));
        System.out.println(s.orchestraLayout(5, 2, 2));
        System.out.println(s.orchestraLayout(3, 0, 2));
        System.out.println(s.orchestraLayout(4, 1, 2));
        System.out.println(s.orchestraLayout(1000000000, 1000, 1));
    }
}
