package com.code.quickSort;

import java.util.Random;

public class QuickSort {

    public int partition(int[] data, int length, int start, int end) throws Exception {
        if(data == null || length <= 0 || start <0 || end >= length)
            throw new Exception("输入非法");
        Random random = new Random();
        int index = start + random.nextInt(end -start + 1); //获取基准元素
        swap(data, end, index);
        int small = start -1 ;

        for(index = start; index < end; ++index){
            if(data[index] < data[end]){  //小于基准元素
                ++small;                    //更新小于基准元素的个数
                if(small != index)          //此时右侧存在比基准元素大的数 //small 指向最左侧比基准大的数
                    swap(data, small, index);
            }
        }
        swap(data, ++small, end);
        return small;
    }

    public void quickSort(int[] data, int length, int start, int end) throws Exception {
        if(start >= end)
            return;
        int index = partition(data, length, start, end);
        if(index > start)
            quickSort(data, length, start, index - 1);
        if(index < end)
            quickSort(data, length,index + 1, end);
    }

    public void swap(int[] data, int a, int b){
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
