package com.code.sort;

import com.code.utils.MyUtils;

public class BubbleSort {

    public void bubbleSort(int[] nums){
        for(int i = 0; i < nums.length - 1; ++i){
            boolean flag = true;
            for(int j = 0 ; j < nums.length - 1-i; ++j){
                if(nums[j -1 ] > nums[j]){
                    MyUtils.swap(nums, j -1, j);
                    flag = false;
                }
            }
            if(flag)
                break;
        }
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] as = {10, 9, 8, 7, 6, 5, 5, 3 , 4,3, 1};
        sort.bubbleSort(as);
        for (int a : as){
            System.out.println(a);
        }
    }

}
