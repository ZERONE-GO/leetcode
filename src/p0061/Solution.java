package p0061;

public class Solution {
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        ListNode vh = new ListNode(0, head);
        int len = 0;
        while(head != null) {
            len ++;
            head = head.next;
        }
        
        k = len - k % len;
        ListNode prev = vh;
        while(k > 0) {
            prev = prev.next;
            k --;
        }
        ListNode end = prev;
        while(end.next != null) {
            end = end.next;
        }
        end.next = vh.next;
        vh.next = prev.next;
        prev.next = null;
        return vh.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
