package com.code.stack;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack =  new LinkedList<>();
        int[] answer = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; ++i){
            if(stack.size() == 0){  //空栈
                stack.push(i);
            }else  {
                while (stack.size() > 0){
                    int j = stack.peek();
                    if(temperatures[j] >= temperatures[i])  break;
                    else {
                        stack.pop();
                        answer[j] = i - j;
                    }
                }
                stack.push(i);
            }
        }
        while (stack.size() > 0){
            int m = stack.pop();
            answer[m] = 0;
        }
        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures temperatures = new DailyTemperatures();
        int[] num = {73,74,75,71,69,72,76,73};
        int[] ints = temperatures.dailyTemperatures(num);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
