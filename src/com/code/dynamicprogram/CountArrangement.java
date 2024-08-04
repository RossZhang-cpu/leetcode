package com.code.dynamicprogram;

public class CountArrangement {

    /*
    Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:

    perm[i] is divisible by i.
    i is divisible by perm[i].
    Given an integer n, return the number of the beautiful arrangements that you can construct.
     */

    public int countArrangement(int n) {
      int[] f = new int[1 << n];
      f[0] = 1;

      for (int mask = 1; mask < 1 << n; ++mask) {
          int currentNum = Integer.bitCount(mask);
          for (int i = 0; (1 << i) <= mask ; ++i) {
                if ((mask & (1 << i)) != 0 && (currentNum % (i + 1) == 0 || (i + 1) % currentNum == 0))
                    f[mask] += f[mask ^ (1 << i)];
          }
      }

      return f[(1 << n) - 1];
    }
}
