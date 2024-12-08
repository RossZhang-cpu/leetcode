package com.code.others;

import com.code.LinkList.ListNode;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.locks.ReentrantLock;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) //小于两个结点
           return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        head = swapDFS(p1, p2);
        return head;
    }

    public ListNode swapDFS(ListNode p1, ListNode p2){
       if(p2.next == null || p2.next.next == null) {
           p1.next = p2.next;
           p2.next = p1;
           return p2;
       }

       p2.next =  swapDFS(p1.next.next, p2.next.next);
       p1.next = p2.next;
       p2.next = p1;
       return p2;
    }

    public static void main(String[] args) throws ParseException {
        new ReentrantLock();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        long currentTime = formatter.parse(String.valueOf(System.currentTimeMillis())).getTime();
        System.out.println(currentTime);

    }
}
