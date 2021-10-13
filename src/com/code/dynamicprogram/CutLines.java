package com.code.dynamicprogram;

public class CutLines {

    public int maxLines(int length){
        if(length <=0)
            return 0;
        else if(length <= 2)
            return 1;
        else if(length == 3)
            return 2;

        int[] dp = new int[length+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max = 0;

        for(int i = 4; i < length+1; ++i){
            max = i;
            for(int j = 1; j <= i/2; ++j){       //避免重复 （2，3） （3，2）
                max = Math.max(dp[j] * dp[i - j], max);
            }
            dp[i] = max;
        }
        return max;
    }

    public int maxLinesGreedy(int length){          //贪心
        if(length <=0)
            return 0;
        else if(length <= 2)
            return 1;
        else if(length == 3)
            return 2;
        int max = 0;

        if(length >= 5) {
            int timeOf3 = length / 3;       //绳子长度大于5
            max = (int) (Math.pow(3, timeOf3) * (length % 3));
        }
        if(length == 4)
            max = 2 * 2;
        return max;
    }

}
