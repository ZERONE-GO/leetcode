package p0706;

import java.util.Arrays;

public class MyHashMapSimple {
    
    private int[] map;
    private static final int SIZE = 1000000;
    
    /** Initialize your data structure here. */
    public MyHashMapSimple() {
        map = new int[SIZE];
        Arrays.fill(map, -1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = -1;
    }

}
