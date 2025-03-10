package com.code.math;

public class MyPow {

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;

        double ans = 1;
        int absN = Math.abs(n);
        for (int i = 1; i <=absN; ++i) {
              ans = ans * x;

        }

        if (n < 0) {
            ans = 1 / ans;
        }
        return ans;
    }
}
