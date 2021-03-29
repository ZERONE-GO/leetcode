package p0083;

public class Solution {
    
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode prev = head;
        ListNode next = head.next;
        
        while(next != null) {
            if(next.val != prev.val) {
                prev.next = next;
                prev = next;
            }
            next = next.next;
        }
        prev.next = next;
        return head;
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
