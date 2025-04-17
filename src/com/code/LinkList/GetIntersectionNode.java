package com.code.LinkList;

public class GetIntersectionNode {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(501);
        dummy.next = head;
        ListNode node = dummy;

        for (int i = 0; i < left - 1; ++i) {
            node = node.next;
        }

        ListNode pre = node.next;
        ListNode cur = node.next.next;
        while (left < right) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            ++left;
        }

        node.next.next = cur;
        node.next = pre;

        return dummy.next;
    }

    public static void main(String[] args) {
        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        getIntersectionNode.reverseBetween(listNode, 1, 2);
    }
}
