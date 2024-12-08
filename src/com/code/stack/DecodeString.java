package com.code.stack;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {

    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        String regex = ".*[a-zA-z].*";
        Deque<String> stack = new LinkedList<>();
        StringBuilder alpha = new StringBuilder();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < chars.length; ++i) {
            if (Character.isAlphabetic(chars[i])) {
                alpha.append(chars[i]);
            } else if (Character.isDigit(chars[i])) {
                if (alpha.length() > 0) {    //数字前面有字符
                    if (!stack.isEmpty() && stack.getFirst() != null && stack.getFirst().matches(regex)) {  // 字符前面为字符
                        String pop = stack.pop();
                        stack.push(pop + alpha.toString());
                    } else {
                        stack.push(alpha.toString());
                    }
                    alpha = new StringBuilder();
                }
                num.append(chars[i]);
            } else if (chars[i] == '[') {   //数字结束
                stack.push(num.toString());
                num = new StringBuilder();
            } else if (chars[i] == ']') {   //该趟结束
                if(stack.getFirst().matches(regex)){    //前面为字符
                    StringBuilder sb = new StringBuilder();
                    sb = sb.append(stack.pop());
                    while (stack.getFirst().matches(regex)){
                        sb.insert(0, stack.pop());
                    }
                    sb.append(alpha);
                    int n = Integer.parseInt(stack.pop());
                    String temp = String.join("", Collections.nCopies(n, sb));
                    stack.push(temp);
                }else {
                    int n = Integer.parseInt(stack.pop());
                    String s1 = String.join("", Collections.nCopies(n, alpha.toString()));
                    stack.push(s1);
                }
                alpha = new StringBuilder();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }

        return sb.toString() + alpha.toString();
    }

    public static void main(String[] args) {
        DecodeString string = new DecodeString();
        String t1 = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String t2 = "sd2[f2[e]g]i";
        String t3 = "3[a]2[b]";
        String s1 = string.decodeString(t1);
        System.out.println(s1);

    }


}
