package com.code;

//给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
//        请你计算并返回该式的最大值。

import java.util.Arrays;

public class MaxProduct {

    public int maxProduct(int[] a) throws Exception {
        if(a.length <= 1)
            throw new Exception("输入错误");

       int max = a[0];
       int lmax = a[1];
       if(max < lmax){
           int temp = max;
           max = lmax;
           lmax = temp;
       }
       for(int i = 2; i < a.length; ++i){
            if(a[i] > max){
                lmax = max;
                max = a[i];
            }else if( a[i] > lmax)
                lmax = a[i];
       }

        return (max - 1) * (lmax - 1);
    }

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        int[] a = {3,4,5,2};
        System.out.println(new MaxProduct().maxProduct(a));
    }
}



