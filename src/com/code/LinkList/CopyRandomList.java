package com.code.LinkList;

import java.util.HashMap;
import java.util.Optional;

public class CopyRandomList {

    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Node current = head;

        Node newHead = new Node(current.val);
        Node newNode = newHead;

        HashMap<Node, Node> currentRandomMap = new HashMap<>();
        HashMap<Node, Node> currentNewMap = new HashMap<>();
        currentNewMap.put(current, newNode);
        currentRandomMap.put(current, current.random);

        for (; current.next != null;) {
            Node next = current.next;
            Node newNextNode = new Node(next.val);
            newNode.next = newNextNode;
            newNode = newNode.next;
            current = current.next;

            currentRandomMap.put(current, current.random);
            currentNewMap.put(next, newNextNode);
        }

        for (newNode = newHead, current = head; current != null;) {
            Node node = currentRandomMap.get(current);
            Node newRandom = currentNewMap.get(node);
            newNode.random = newRandom;

            newNode = newNode.next;
            current = current.next;
        }

        return newHead;
    }


    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
