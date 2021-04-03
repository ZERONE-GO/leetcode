package p5705;

public class Solution {

    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 'a' + 1;
        int y = Integer.valueOf(coordinates.substring(1));
        
        return ((x&1) == 1 && (y&1) != 1) ||((x&1) !=0 &&(y&1) == 0); 
    }
}
