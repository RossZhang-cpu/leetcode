package com.code.sort;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
       if(nums.length <= 1) return;

       int i = nums.length - 1;
       int j = nums.length - 2;
       int len = nums.length;
       while (j >= 0){
           if(nums[j] < nums[i]) break;
           else  {
               --j;
               --i;
           }
       }

       if(j > -1){
          int m = len - 1;
          for(; m >= i; --m){
              if(nums[m] > nums[j]) break;
          }
          int temp = nums[m];
          nums[m] = nums[j];
          nums[j] = temp;
       }

       for(int l = len - 1;  i < l; ++i, --l){
           int temp = nums[i];
           nums[i] = nums[l];
           nums[l] = temp;
       }

    }




}
