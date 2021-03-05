package p0002;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        int plus = 0;
        ListNode sum = new ListNode();
        ListNode next = sum;
        while (l1 != null && l2 != null) {
            next.next = new ListNode((l1.val + l2.val + plus) % 10);
            plus = (l1.val + l2.val + plus) / 10;
            next = next.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            next.next = new ListNode((l1.val + plus) % 10);
            plus = (l1.val + plus) / 10;
            next = next.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            next.next = new ListNode((l2.val + plus) % 10);
            plus = (l2.val + plus) / 10;
            next = next.next;
            l2 = l2.next;
        }

        if (plus > 0) {
            next.next = new ListNode(plus);
        }
        return sum.next;
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