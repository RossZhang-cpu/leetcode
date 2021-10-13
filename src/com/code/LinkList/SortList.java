package com.code.LinkList;

public class SortList {
    /**
     * Definition for singly-linked list.
     *
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     *
     **/

//    在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
    //归并排序    基于分治法
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null){
            if(left.val <= right.val){
                h.next = left;
                left = left.next;
            }else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return  res.next;
    }
}
