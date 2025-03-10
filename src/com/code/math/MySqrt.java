package com.code.math;

public class MySqrt {

    public int mySqrt(int x) {
        int left = 0, right = x;

        while (left <= right) {
            long mid = (left + right) >>> 1;
            if ((mid * mid) > x) {
                right = (int) (mid - 1);
            } else {
                left = (int) (mid + 1);
            }
        }

        return right;

    }

    public static void main(String[] args) {
        int i = new MySqrt().mySqrt(2147395599);
    }
}
