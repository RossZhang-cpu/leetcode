package com.code.math;

public class TrailingZeroes {

    public int trailingZeroes(int n) {
        long sum = 1;
        for (int i = 1; i <= n; ++i) {
            sum *= i;
        }

        int ans = 0;
        while (sum % 10 == 0) {
            sum = sum  / 10;
            ++ans;
        }

        return ans;
    }


    public static void main(String[] args) {
        new TrailingZeroes().trailingZeroes(13);
    }
}
