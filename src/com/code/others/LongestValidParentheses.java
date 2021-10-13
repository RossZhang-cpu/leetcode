package com.code.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LongestValidParentheses {

//    给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//    输入: "(()"
//    输出: 2
//    解释: 最长有效括号子串为 "()"
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0)
            return 0;

        var stack = new Stack<Integer>();
        char[] ch = s.toCharArray();
        int count  = 0;
        int max = 0;
        stack.push(-1);

        for(int i = 0; i < ch.length; ++i){
            if(ch[i] == '('){
                stack.push(i);
            }else if(ch[i] == ')'){
               stack.pop();
               if(stack.empty())
                   stack.push(i);
               else {                   //  回退到上一个位置
                max = Math.max(max, i - stack.peek());
               }
            }
        }
        return max;
    }

    public int dpLongestValidParentheses(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 0);

        for(int i = 1; i < chars.length; ++i){
            if(chars[i] == ')' ){
                if( chars[i - 1] == '(') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                }else if(chars[i - 1] == ')' && chars[i - dp[i -1] -1] == '('){  //连续配对
                    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
