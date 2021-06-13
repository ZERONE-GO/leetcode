package p5784;

import java.util.Arrays;

class Solution {
    public boolean makeEqual(String[] words) {
        int[] count = new int[26];
        
        for(int i=0; i < words.length; i ++) {
            for(int j=0; j < words[i].length(); j ++) {
                count[words[i].charAt(j) - 'a'] ++;
            }
        }
        
        int size = words.length;
        for(int i=0; i < 26; i ++) {
            if(count[i] % size  != 0) {
                return false;
            }
        }
        return true;
    }
}