package com.code.others;

//Given a non-empty array nums containing only positive integers, find if the ar
//ray can be partitioned into two subsets such that the sum of elements in both su
//bsets is equal.
//
//
// Example 1:
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
//
//
// Example 2:
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
//
//
//
// Constraints:
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
//
//dp[i][j]=
//        ⎩
//        ⎪
//        ⎪
//        ⎨
//        ⎪
//        ⎪
//        ⎧
//        ​
//
//        dp[i−1][j],
//        true,
//        dp[i−1][j−nums[i]].
//        ​
//
//        至少是这个答案，如果 dp[i−1][j] 为真，直接计算下一个状态
//        nums[i] = j
//        nums[i] < j

public class CanPartition {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        //如果为奇数，结束
        if((sum & 1) == 1){
            return false;
        }
        int target = sum / 2;
        //生成二维数组
        boolean dp[][] = new boolean[len][target + 1];
        if(nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for(int i = 1; i < nums.length; ++i){
            for(int j = 0; j < target + 1; ++j){
                dp[i][j] = dp[i - 1][j];
                if(nums[i] == j){
                    dp[i][j] = true;
                }else if(nums[i] < j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }
}
