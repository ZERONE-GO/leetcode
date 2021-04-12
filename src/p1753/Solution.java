package p1753;

public class Solution {
    
    public int maximumScore(int a, int b, int c) {
      if(a > c) {
          int tmp = a;
          a = c;
          c = tmp;
      }
      if(b > c) {
          int tmp = b;
          b = c;
          c = tmp;
      }
      
      int result = -1;
      for(int i=0; i < Math.min(a, b); i ++) {
          int value = b + Math.min(a-i, c-b+i);
          if(value > result) {
              result = value;
          }
      }
      return result;
    }
}
