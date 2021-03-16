package p0706;

public class MyHashMap {
    private Pair[] map;
    private static final int SIZE = 769;
    private Pair vh;

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new Pair[SIZE];
        vh = new Pair(-1, -1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = hash(key);
        Pair bucket = map[h];
        while(bucket != null) {
            if(bucket.key == key) {
                bucket.value = value;
                return;
            }
        }
        Pair pair = new Pair(key, value);
        pair.next = map[h];
        map[h] = pair;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        int h = hash(key);
        Pair bucket = map[h];
        while(bucket != null) {
            if(bucket.key == key) {
                return bucket.value;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        int h = hash(key);
        vh.next = map[h];
        Pair prev = vh;
        Pair next = prev.next;
        while(next != null) {
            if(next.key == key) {
                prev.next = next.next;
                map[h] = vh.next;
                return;
            }
            prev = next;
            next = prev.next;
        }
    }
    
    public int hash(int key) {
        return key % SIZE;
    }

    private class Pair {
        private int key;
        private int value;
        private Pair next;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
