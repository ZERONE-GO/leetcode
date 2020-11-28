package p0234;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head, quick = head.next;

        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }

        ListNode pre = null, next = head;

        while (next != slow) {
            ListNode tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;
        }

        ListNode left, right;
        if (quick == null) {
            right = slow.next;
            left = pre;
        } else {
            if (slow.next == null || slow.next.val != slow.val) {
                return false;
            }

            left = pre;
            right = slow.next.next;
        }

        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
