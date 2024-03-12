package com.code;

import java.util.Deque;
import java.util.LinkedList;

public class Calculator {


    public int calculate(String s) {
        String s1 = s.replaceAll(" ", "");
        Deque<Integer> numStack = new LinkedList<>();
        Deque<Character> operaStack = new LinkedList<>();

        int value = 0;
        char[] array = s1.toCharArray();
        for (int i = 0; i < s1.length(); ++i) {
            int diff = array[i] - '0';
            int start = i;
            int end = -1;
            for (;diff >= 0 && diff <= 9 && (end = i + 1) < s1.length();) {
                diff = array[++i] - '0';
            }
            if (end != -1) {
                value = Integer.parseInt(s1.substring(start, end));
                numStack.push(value);
            }
            //non-number occurs
            if (diff < 0 || diff > 9) {
                //decide if calculator
                while (numStack.size() > 1) {
                    if (isAbleToCalculator(operaStack.peek(), array[i])) {
                        value = doCalculator(numStack.pop(), numStack.pop(), operaStack.pop());
                        numStack.push(value);
                    } else {
                        break;
                    }
                }
                operaStack.push(array[i]);
            }
        }
        while (!operaStack.isEmpty()) {
            value = doCalculator(numStack.pop(), numStack.pop(), operaStack.pop());
            numStack.push(value);
        }
        return value;
    }

    private int doCalculator(Integer second, int first, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                return first / second;
        }
        return result;
    }

    private boolean isAbleToCalculator(char peek, char c) {
        int result = getPriority(peek) - getPriority(c);
        return result >= 0;
    }

    private int getPriority(char ch) {
        if (ch == '+' || ch == '-') {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int calculate = calculator.calculate("3+2*2");
        System.out.println(calculate);
    }
}
