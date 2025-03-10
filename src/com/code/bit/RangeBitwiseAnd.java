package com.code.bit;

public class RangeBitwiseAnd {

    public int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        int curBit = 0;
        for (int j = 0; j < 32; ++j) {
            int leftBit = left >> j & 1;
            int rightBit = right >> j & 1;
            curBit = leftBit & rightBit;
            if (curBit == 1 && right - left <= (1 << j)){
                curBit = 1;

            } else curBit = 0;

            ans += curBit << j;
        }
        return ans;
    }

    public static void main(String[] args) {
        new RangeBitwiseAnd().rangeBitwiseAnd(1073741824, 2147483647);
    }
}
