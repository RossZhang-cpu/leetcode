package com.code.LinkList;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HasCycle {
//    给定一个链表，判断链表中是否有环。
//    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，
//    则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//    如果链表中存在环，则返回 true 。 否则，返回 false 。

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null ) return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        return slow == fast;
    }

//    给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
//    如果 pos 是 -1，则在该链表中没有环。
//    说明：不允许修改给定的链表。
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        var map = new HashMap<ListNode, Integer>();
        ListNode node = head;
        int index = 0;

        while (node != null ){
            if(map.get(node) == null){
                map.put(node, index);
                ++index;
            }else break;
            node = node.next;
        }
        if(node == null) return null;
        else return node;
    }

//    总结关键点：
//
//            1.第一次相遇，slow = nb
//2.a+nb = 入口点
//3.slow再走a = 入口 = head走到入口 = a
//4.由3得出，起始距离入口 = 第一次相遇位置 + a
//    感觉就是数学公式推导+逻辑结合的一道题
    public ListNode detectCycle02(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) break;
        }
        if(fast != slow) return null;
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
//        new ConcurrentHashMap<>();
    }
}

