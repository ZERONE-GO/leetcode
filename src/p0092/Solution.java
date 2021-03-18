package p0092;

public class Solution {
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) {
            return head;
        }
        
        ListNode vh = new ListNode(0, head);
        
        ListNode leftNode = vh;
        int index = 1;
        while(index < left) {
            leftNode = leftNode.next;
            index++;
        }
        
        ListNode begin = leftNode.next;
        ListNode prev = leftNode.next;
        ListNode next = leftNode.next.next;
        while(index < right) {
            ListNode tmp = next.next;
            next.next = prev;
            prev = next;
            next = tmp;
            index ++;
        }
        begin.next = next;
        leftNode.next = prev;
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
