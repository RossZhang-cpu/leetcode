package com.code.hash;

import java.util.HashSet;
import java.util.Set;

public class IsHappyNum {
    public boolean isHappy(int n) {
        Set<Integer> memoTab = new HashSet<>();

        boolean isHappy = true;
        while(isHappy) {
            int res = 0;
            for(int temp = n; temp > 0; temp = temp / 10) {
                res += (int) Math.pow((temp % 10), 2);
            }

            if (res == 1) {
                break;
            } else {
                if (memoTab.contains(res)) {
                    isHappy = false;
                    break;
                } else {
                    memoTab.add(res);
                }
            }
            n = res;
        }

        return isHappy;
    }

}
