package com.code.dynamicprogram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak {
//    给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
//    说明：
//
//    拆分时可以重复使用字典中的单词。
//    你可以假设字典中没有重复的单词。
//    示例 1：
//    输入: s = "leetcode", wordDict = ["leet", "code"]
//    输出: true
//    解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。

    public boolean wordBreak(String s, List<String> wordDict) {
       boolean[] dp = new boolean[s.length() + 1];
       dp[0] = true;

       for(int i = 1; i < dp.length; ++i){   //dp 指针
           for (int j = i -1; j >= 0; --j){     // str 指针
               dp[i] = dp[j] && wordDict.contains(s.substring(j, i));
               if(dp[i]) break;
           }
       }
        return dp[dp.length];
    }

    public static void main(String[] args) {
//        var list = new ArrayList<String>();
//        list.add("apple");
//        list.add("pen");
//        new Class<>();
//        new Object()
        StringBuilder[] strings = new StringBuilder[1];
        StringBuilder nn = new StringBuilder( "a");
        strings[0] = nn;
        nn.append("b");
        System.out.println(strings[0]);
        new ArrayList<>().size();

//        new HashMap<>();
//        WordBreak wordBreak = new WordBreak();
//        System.out.println(wordBreak.wordBreak("applepenapple", list));
    }
}
