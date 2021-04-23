package p0024;

public class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode vh = new ListNode(0, head);
        ListNode pre = vh;

        while (pre.next != null && pre.next.next != null) {
            ListNode tmp = pre.next;
            pre.next = pre.next.next;
            tmp.next = pre.next.next;
            pre.next.next = tmp;
            pre = tmp;
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
