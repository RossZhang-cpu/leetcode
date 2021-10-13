package com.code.stack;

import com.code.LinkList.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class Valid {
//    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//    有效字符串需满足：
//
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。
//    注意空字符串可被认为是有效字符串。
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;

        char[] ch = s.toCharArray();
        var stack = new LinkedList<Character>();
        var left = new ArrayList<Character>();
        var right = new ArrayList<Character>();
        left.add('('); left.add('['); left.add('{');
        right.add(')'); right.add(']'); right.add('}');
        int i = 0;
        for(; i < ch.length; ++i){
            if(left.contains(ch[i])) stack.push(ch[i]);
            else {
                if(stack.peek() == null) break;
                char cur = stack.peek();
                if(left.indexOf(cur) == right.indexOf(ch[i])) stack.pop();
                else break;
            }
        }
        return i == ch.length && stack.isEmpty();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null ) return l2;
        if(l2 == null) return l1;
        ListNode front = new ListNode();
        if(l1.val < l2.val) {
            front = l1;
            l1 = l1.next;
        } else {
            front = l2;
            l2 = l2.next;
        }
        ListNode head = front;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                front.next = l1;
                l1 = l1.next;
                front = front.next;
            }else {
                front.next = l2;
                l2 = l2.next;
                front = front.next;
            }
        }
        if(l2 != null) front.next = l2;
        if(l1 != null) front.next = l1;
        return head;

    }

    public static void main(String[] args) {
        new ConcurrentHashMap();
    }

}
