package com.code;
import java.util.*;

public class Solution {

    public class Interval {
        int start;
        int end;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回Interval类，start代表汪仔最少做对了多少道题，end代表汪仔最多做对了多少道题。
     * @param n int整型 选择题总数
     * @param k int整型 朋友做对的题数
     * @param str1 string字符串 长度为n只包含ABCD的字符串，其中第i个代表汪仔第i题做出的选择
     * @param str2 string字符串 长度为n只包含ABCD的字符串，其中第i个代表朋友第i题做出的选择
     * @return Interval类
     */
    public Interval solve (int n, int k, String str1, String str2) {
        Interval interval = new Interval();
        // write code here
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int noteq = 0; int eq = 0;
        for(int i = 0 ; i < chars1.length; ++i){
            if(chars1[i] == chars2[i])
                ++eq;
            else
                ++noteq;
        }
        if( k < noteq)
            interval.start = 0;
        else
            interval.start =  n - (k - noteq);
        if(k < eq)
            interval.end = n - (eq - k);
        else
            interval.end = n -(k - eq);
        return interval;
    }


        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 返回一行字符串，表示原文。
         * @param s1 string字符串一维数组 N*N的01矩阵，表示解密纸，0表示透明，1表示涂黑
         * @param s2 string字符串一维数组 字符矩阵，表示密文
         * @return string字符串
         */
//        ["1101","1010","1111","1110"],["ABCD","EFGH","IJKL","MNPQ"]
//        "CFHQGLMPAIKNBDEJ"

    public String rotatePassword (String[] s1, String[] s2) {
        // write code here
        int n = s1[0].length();
        for(int i = 0; i < n; ++i){
            char[] chars = s1[i].toCharArray();
            for(char ch :chars){
                if(ch == '0');
            }
        }
        for(int i = 0 ; i < 4; ++i){

        }
        return "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(3, 3, "ABC", "ABC"));
    }
}