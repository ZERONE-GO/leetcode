package p0331;

public class Solution {
    
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int index = valid(nodes, 0, nodes.length);
        return index == nodes.length - 1;
    }
    
    private int valid(String[] nodes, int index, int len) {
        if(nodes[index].equals("#")) {
            return index;
        }
        
        if(index + 1 < len) {
            int left = valid(nodes, index + 1, len);
            if(left >=0 && left + 1 < len) {
                return valid(nodes, left + 1, len);
            }
        }
        return -1;
    }
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.print(s.isValidSerialization("9,#,#,1"));
    }

}
