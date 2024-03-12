package com.code.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack2 {
    //using one queue
    private Queue<Integer> queue;

    public MyStack2() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        while (n > 0) {
            queue.offer(queue.poll());
            --n;
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }



}
