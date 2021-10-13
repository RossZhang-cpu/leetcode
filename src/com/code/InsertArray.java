package com.code;

public class InsertArray {
    public static void insertArray(int[] A1, int[] A2){

        int i = 0; int j = A2.length;
        for (; A1[i]!=0; ++i){

        }

        int tail = i + j - 1;  //从尾部开始的下标
        --i; //回到尾部 开始比较
        --j;

        while(i >=0 && j >= 0) {            //两个都没有遍历完
            int result = A1[i] - A2[j];
            if (result >= 0) {   //A1 大 填入 尾部
                A1[tail--] = A1[i--];
            } else {
                A1[tail--] = A2[j--];
            }
        }
        while (j >= 0 ){
            A1[tail--] = A2[j--];
        }


    }
}
