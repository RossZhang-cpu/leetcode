package com.code.LinkList;

public class IntersectionList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        if(headA == headB)
            return headA;

        int n = 1, m = 1;
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA.next != null){
            nodeA = nodeA.next;
            ++n;
        }
        while (nodeB.next != null){
            nodeB = nodeB.next;
            ++m;
        }
        int step = Math.abs(n - m);
        ListNode first;
        if(n > m){
            nodeA = moveStep(step, headA);
            nodeB = headB;
        }else{
            nodeB = moveStep(step, headB);
            nodeA = headA;
        }
        if(nodeA == nodeB)
            return nodeA;
        else{
            while(nodeA != null){
                if(nodeA.next == nodeB.next){
                    return nodeA.next;
                }
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
        }
        return  nodeA;
    }

    public ListNode moveStep(int step, ListNode first){
        while(step > 0){
            first = first.next;
            --step;
        }
        return first;
    }
}
