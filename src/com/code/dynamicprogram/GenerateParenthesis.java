package com.code.dynamicprogram;

import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {
//    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

    /*动态规划
    剩下的括号要么在这一组新增的括号内部，要么在这一组新增括号的外部（右侧）。

既然知道了 i<n 的情况，那我们就可以对所有情况进行遍历：

"(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】

其中 p + q = n-1，且 p q 均为非负整数。

事实上，当上述 p 从 0 取到 n-1，q 从 n-1 取到 0 后，所有情况就遍历完了。

注：上述遍历是没有重复情况出现的，即当 (p1,q1)≠(p2,q2) 时，按上述方式取的括号组合一定不同。

     */
    public List<String> generateParenthesis(int n) {
        String str = null;
        var list = new LinkedList<LinkedList<String>>();
        var resultLists = new LinkedList<String>();
        var list00 =new LinkedList<String>();
        var list01  = new LinkedList<String>();


        list00.add("");
        list01.add("()");
        list.add(list00);
        list.add(list01);

        for(int i = 2; i <= n; ++i) {
            var temp = new LinkedList<String>();
            for (int j = 0; j <= i - 1; ++j) {
                for (int m = 0; m < list.get(j).size(); ++m) {
                    for (int z = 0; z < list.get(i - 1 - j).size(); ++z) {
                        str = "(" + list.get(j).get(m) + ")" + list.get(i - 1 - j).get(z);
                        temp.add(str);
                    }
                }
            }
            list.add(temp);
        }
        return list.get(n);
    }

    public static void main(String[] args) {

    }
}
