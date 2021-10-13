package com.code;


//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
//在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//        输入：[1,8,6,2,5,4,8,3,7]
//        输出：49
//解法：双指针
public class MaxArea {
    public static void maxArea(int[] a){
        int i = 0; int j = a.length - 1;
        int res = 0;
        while (i < j){
            int area = (j - i) * Math.min(a[i], a[j]);
            res = area >= res ? area : res;
            if(a[i] <= a[j]){
                ++i;
            }else{
                --j;
            }
        }
        System.out.println(res);
    }
}
