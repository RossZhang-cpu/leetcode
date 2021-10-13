package com.code.LinkList;


import com.code.MaxSubArrayProduct;

import java.util.List;

public class ReverseList {

//    反转一个单链表。
//    示例:
//    输入: 1->2->3->4->5->NULL
//    输出: 5->4->3->2->1->NULL
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;

        ListNode node = head;
        node = node.next;
        ListNode rhead = recurse(head, node);
        head.next = null;
        return rhead;
    }

    public ListNode recurse(ListNode head, ListNode node){
        if(node.next == null){
            node.next = head;
            return node;
        }

        ListNode rhead = recurse(node, node.next);
        node.next = head;
        return rhead;
    }

    public static void main(String[] args) {

        }
}

