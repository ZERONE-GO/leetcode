package p5830;

public class Solution {

    
    public boolean isThree(int n) {
        int count = 1;

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count == 3;
    }
}
