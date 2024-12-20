package com.code.LinkList;

public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        int nodeCount = 0;
        ListNode cur = head;
        while (cur != null) {
            ++nodeCount;
            cur = cur.next;
        }

        if (nodeCount == 0)
            return head;

        int m = k % nodeCount;
        if (m == 0)
            return head;


        int preNode = nodeCount - m;
        cur = head;
        for (int i = 1; i < preNode; ++i) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        ListNode endNode = cur.next;
        while (endNode.next != null) {
            endNode = endNode.next;
        }

        cur.next = null;
        endNode.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode1;
        listNode1.next = listNode2;

        RotateRight rotateRight = new RotateRight();
//        rotateRight.rotateRight(listNode, 4);
        rotateRight.rotateRight(null, 0);
    }
}
