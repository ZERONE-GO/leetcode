package p5694;

import java.util.HashMap;
import java.util.Map;

class AuthenticationManager {

    private Map<String, Integer> map;

    private final int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.get(tokenId) != null) {
            if (map.get(tokenId) + timeToLive < currentTime) {
                map.put(tokenId, currentTime);
            } else {
                map.remove(tokenId);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (String key : map.keySet()) {
            if (map.get(key) + timeToLive < currentTime) {
                count++;
            } else {
                map.remove(key);
            }
        }
        return count;
    }
}
