package com.code.others;

public class MoveZeroes {

//    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//    输入: [0,1,0,3,12]
//    输出: [1,3,12,0,0]
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 0)
            return;

        int start = -1, end =-1;
        int curr = 0;
        for(; curr < nums.length; ++curr){
            if(nums[curr] == 0){
                if(end - start == 0){     //此时没有0
                    start = curr;
                    end = curr + 1;
                }else{
                    end = curr + 1;
                }
            }else if(end -start > 0){
                int temp = nums[curr];
                nums[curr] = nums[start];
                nums[start] = temp;
                ++start ;
                ++end;
            }

        }
    }
}
