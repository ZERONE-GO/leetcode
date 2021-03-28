package p5713;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    
    public int numDifferentIntegers(String word) {
        Set<Integer> result = new HashSet<>();
        
        int num = 0;
        boolean flag = false;
        for(int i=0; i < word.length(); i ++) {
            if(isNum(word.charAt(i))) {
                num = num * 10 + word.charAt(i) - '0';
                flag = true;
            } else {
                if(flag) {
                    result.add(num);
                }
                flag = false;
                num  = 0;
            }
        }
        if(flag) {
            result.add(num);
        }
        
        return result.size();
    }
    
    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

}
