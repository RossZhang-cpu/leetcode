package com.code.others;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        //投票算法
        //摩尔投票法，遇到相同的数，就投一票，遇到不同的数，就减一票，最后还存在票的数就是众数
        int count  = 0;
        int maj = 0;

        for (int num : nums){
            if (count == 0) {
                maj = num;
            }
            if (maj == num){
               ++count;
            }else {
                --count;
            }
        }
        return maj;
    }

    public static void main(String[] args) {
        int result = 5 / 2;
        System.out.println(result);
    }
}
