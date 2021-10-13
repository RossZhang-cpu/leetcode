package com.code.LinkList;

import java.util.*;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return null;

        char[] chars = digits.toCharArray();  //号码
        String[] str = new String[10];         //对应的字符
        str[0] = "";
        str[1] = "";
        str[2] = "abc";
        str[3] = "def";
        str[4] = "ghi";
        str[5] = "jkl";
        str[6] = "mno";
        str[7] = "pqrs";
        str[8] = "tuv";
        str[9] = "wxyz";

        Queue<String> queue = new LinkedList<>();
        int num = Character.getNumericValue(chars[0]);
        char[] chars1 = str[num].toCharArray();
        for (char c : chars1)
            queue.offer((String.valueOf(c)));

        for(int i = 1; i < chars.length; ++i) {
            num = Character.getNumericValue(chars[i]);
            char[] cur = str[num].toCharArray();
            int len = queue.size();

            for (int j = 0; j < len && !queue.isEmpty(); ++j) {
                String s = queue.poll();
                for (char ch : cur) {
                    queue.offer(s + ch);
                }
            }
        }

        List<String> list = new ArrayList<>();
        while (!(queue.isEmpty())){
            list.add(queue.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        new LetterCombinations().letterCombinations("53");
    }
}
