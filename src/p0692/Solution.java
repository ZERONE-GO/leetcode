package p0692;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for(String w : words) {
            if(map.containsKey(w)) {
                map.put(w, map.get(w) + 1);
            } else {
                map.put(w, 0);
            }
        }

        List<String> keys = new ArrayList<String>();
        for(String key : map.keySet()) {
            keys.add(key);
        }

        keys.sort((a,b ) -> {
            if(map.get(a) == map.get(b)) {
                return a.compareTo(b);
            } else {
                return map.get(b) - map.get(a);
            }
        });

        return keys.subList(0, k);
    }
}
