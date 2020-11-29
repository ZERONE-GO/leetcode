package p0025;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode vh = new ListNode(0, head);
        ListNode prek = vh;

        int batch = k;
        ListNode bs = vh.next;
        ListNode pe = vh;
        do {
            while (prek != null && batch > 0) {
                prek = prek.next;
                batch--;
            }

            if (prek != null) {
                ListNode tmp = prek.next;
                ListNode bh = reverseList(bs, prek);
                pe.next = bh;
                pe = bs;
                pe.next = tmp;
                bs = tmp;
                prek = tmp;
                batch = k - 1;
            }
        } while (prek != null);

        return vh.next;
    }

    private ListNode reverseList(ListNode start, ListNode end) {
        ListNode pre = start, next = start.next;
        while (pre != end) {
            ListNode tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;
        }
        return pre;
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
