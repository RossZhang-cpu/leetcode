package com.code.sort;

public class BubbleSort2 {

    public void bubbleSort(int[] nums){
        for(int i = 0; i < 2; ++i){
            for(int j = 0; j < 2 - i ; ++j){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                }
            }
        }
    }
}
