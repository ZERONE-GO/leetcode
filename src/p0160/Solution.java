package p0160;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;
        boolean flag1 = true, flag2 = true;
        while (node1 != node2) {
            if (node1.next != null) {
                node1 = node1.next;
            } else if(flag1){
                node1 = headB;
                flag1 = false;
            } else {
                return null;
            }

            if (node2.next != null) {
                node2 = node2.next;
            } else if(flag2){
                node2 = headA;
                flag2 = false;
            } else {
                return null;
            }
        }

        return node1;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
