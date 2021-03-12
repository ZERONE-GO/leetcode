package p1005;

public class Solution {
    
    public int findString(String[] words, String s) {
        int left =0, right = words.length;
        
        while(left < right) {
            int mid = (left+right) / 2;
            int tmp = mid;
            while( tmp >= left && words[tmp].equals("")) {
                tmp --;
            }
            if (tmp >= left ) {
                mid = tmp;
            } else {
                tmp = mid;
                while( tmp < right && words[tmp].equals("")) {
                    tmp ++;
                }
                mid = tmp;
            }
            if(mid < left || mid >= right) {
                return -1;
            }
            if(s.equals(words[mid])) {
                return mid;
            } else if(s.compareTo(words[mid]) >0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
    
    public static void main(String args[]) {
        String[] words = {"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""};
        Solution s = new Solution();
        System.out.println(s.findString(words, "ta"));
    }

}
