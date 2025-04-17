package com.code.LinkList;

public class MergeList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(100);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1 == null || list2 == null) {
                cur.next = (list1 == null) ? list2 : list1;
                break;
            }

            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
