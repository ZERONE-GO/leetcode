package p0705;

public class MyHashSet {
    
    private byte[] map; 
    
    private static final int SIZE = 200000;
    
    public MyHashSet() {
        map = new byte[SIZE];
    }
    
    public void add(int key) {
        int i = key / 8;
        int b = key % 8;
        map[i] = (byte) (map[i] | (0x1 << b));
    }
    
    public void remove(int key) {
        if(contains(key)) {
            int i = key / 8;
            int b = key % 8;
            map[i] = (byte) (map[i] ^ (0x1 << b));
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = key / 8;
        int b = key % 8;
        return (map[i] & (0x1 << b)) != 0;
    }
    
    public static void main(String args[]) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        set.contains(1);
    }

}
