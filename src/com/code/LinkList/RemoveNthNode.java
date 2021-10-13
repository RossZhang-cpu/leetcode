package com.code.LinkList;

public class RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;

        ListNode front = head;
        ListNode rear = head;
        for(int i = 0; i < n; ++i){
            rear = rear.next;
        }
        while (rear != null && rear.next != null){
            rear = rear.next;
            front = front.next;
        }
        if(rear == null) {
            head = head.next;
        }else {
            ListNode delNode = front.next;
            front.next = delNode.next;
            delNode.next = null;
        }
        return head;
    }
}
