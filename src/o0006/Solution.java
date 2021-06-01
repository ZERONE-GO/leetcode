package o0006;


class Solution {
   public int[] reversePrint(ListNode head) {
       return reverse(head, 0);
   }
   
   private int[] reverse(ListNode node, int depth) {
       if(node == null) {
           return new int[depth];
       }
       
       int[] num = reverse(node.next, depth + 1);
       num[num.length - depth - 1] = node.val;
       return num;
   }
   
   
   public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
}
