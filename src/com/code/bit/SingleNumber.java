package com.code.bit;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i ) & 1;
            }
            int temp = sum % 3;
//            System.out.println("temp :"+ temp);
            res += (temp<< i);
//            System.out.println(res);
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        singleNumber.singleNumber(new int[]{2, 2, 2,3});
    }
}
