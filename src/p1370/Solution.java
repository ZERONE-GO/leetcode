package p1370;

public class Solution {
    
    
    public String sortString(String s) {
        char[] c = new char[26];
        
        for(int i=0; i < s.length(); i ++) {
            c[s.charAt(i) - 'a']  ++;
        }
        
        String result = "";
        
        boolean change = true;
        while(change) {
            change = false;
            for(int i=0; i < 26; i ++) {
                if(c[i] != 0) {
                    result += (char)('a' + i);
                    c[i] --;
                    change = true;
                }
            }
            
            for(int i=25; i >=0; i --) {
                if(c[i] != 0) {
                    result += (char)('a' + i);
                    c[i] --;
                    change = true;
                }
            }
        }
        
        return result;
    }
    

}
