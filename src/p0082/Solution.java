package p0082;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode vh = new ListNode(0, head);
        ListNode prev = vh;
        ListNode next = vh.next;
        
        while(next != null) {
            boolean skiped = false;
            while(next.next != null && next.val == next.next.val) {
                next = next.next;
                skiped = true;
            }
            if(skiped) {
                prev.next = next.next;
            } else {
                prev = next;
            }
            next = next.next;
        }
        
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
