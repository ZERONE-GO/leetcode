package p1366;

import java.util.Arrays;

public class Solution {
    
    public String rankTeams(String[] votes) {
        int len = votes[0].length();
        int[][] score = new int[26][len];
        
        for(int i=0; i < votes.length; i ++) {
            String vote = votes[i];
            for(int j=0; j < len; j ++) {
                score[vote.charAt(j)-'A'][j] ++;
            }
        }

        Integer[] vote = new Integer[26];
        for(int i=0; i < 26; i ++) {
            vote[i] = i;
        }
        
        Arrays.sort(vote, (a, b) -> {
            for(int i=0; i < len; i ++) {
                if(score[a][i] < score[b][i]) {
                    return 1;
                } else if (score[a][i] > score[b][i]) {
                    return -1;
                }
            }
            return  a-b;
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < len; i ++) {
            sb.append((char)(vote[i]+'A'));
        }
        
        return sb.toString();
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        String[] votes = {"BCA","CAB","CBA","ABC","ACB","BAC"};
        System.out.println(s.rankTeams(votes));
    }

}
