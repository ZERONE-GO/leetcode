package p1773;

import java.util.List;

public class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        
        int index = 0;
        if("type".equals(ruleKey)) {
            index = 0;
        } else if ("color".equals(ruleKey)) {
            index = 1;
        } else {
            index = 2;
        }
        
        
        for(int i=0; i < items.size(); i ++) {
            if(ruleValue.equals(items.get(i).get(index))) {
                count ++;
            }
        }
        
        return count;
    }

}
