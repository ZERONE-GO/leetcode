package p0019;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode vh = new ListNode(0, head);
        ListNode pre = vh;
        ListNode last = vh;

        while (n > 0) {
            pre = pre.next;
            n--;
        }

        while (pre.next != null) {
            pre = pre.next;
            last = last.next;
        }

        last.next = last.next.next;

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
