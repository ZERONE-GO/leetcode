package p1769;

public class Solution {
    
    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        
        for(int i=0; i < boxes.length(); i ++) {
            for(int j=0; j < boxes.length(); j ++) {
                if(boxes.charAt(j) == '1') {
                    result[i] += Math.abs(j - i);
                }
            }
        }
        
        return result;
    }

}
