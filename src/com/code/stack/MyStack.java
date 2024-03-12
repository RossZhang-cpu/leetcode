package com.code.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    //using
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int top;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x);
        top = x;
    }

    public int pop() {
        if (queue1.isEmpty()) {
            return 0;
        }
        int nextTop = 0;
        while (queue1.size() > 1) {
            Integer peek = queue1.poll();
            if (queue1.size() == 1) {
                nextTop = peek;
            }
            queue2.offer(peek);
        }

        int pop = queue1.poll();
        top = nextTop;
        switchQueue();
        return pop;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }


    private void switchQueue() {
        if (queue1.size() < queue2.size()) {
            Queue<Integer> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }
    }

    public static void main(String[] args) {

    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
