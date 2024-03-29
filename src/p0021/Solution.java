package p0021;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode vh = new ListNode();

        ListNode head = vh;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }

        if (l1 != null) {
            head.next = l1;
        } else if (l2 != null) {
            head.next = l2;
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
