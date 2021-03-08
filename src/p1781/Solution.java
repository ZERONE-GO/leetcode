package p1781;

public class Solution {
    
    public int beautySum(String s) {
        int result = 0;
        
        for(int i=0; i < s.length(); i ++) {
            int cnt[] = new int[26];
            for(int j=i; j < s.length(); j ++) {
                cnt[s.charAt(j) - 'a'] ++;
                
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int k=0; k < 26; k ++) {
                    max = max > cnt[k] ? max : cnt[k];
                    min = min < cnt[k] || cnt[k] == 0 ? min : cnt[k];
                }
                result += (max-min);
            }
        }
        
        return result;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.beautySum("aabcb"));
    }

}
