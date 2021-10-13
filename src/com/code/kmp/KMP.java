package com.code.kmp;

public class KMP {
    private int[][] dp;
    private String pat;

    public KMP(String pat){
        this.pat = pat;
        dp = new int[pat.length()][256];
        dp[0][pat.charAt(0)] = 1;
        int j = 1;
        int X = 0;
        for(; j < pat.length(); ++j){
            for(int c = 0; c < 256; ++c){
                if(pat.charAt(j) == c)
                    dp[j][c] = j + 1;
                else
                    dp[j][c] = dp[X][c];
            }
            //更新影子状态
            X = dp[X][pat.charAt(j)];
        }

    }

    public int search(String txt){
        int M = pat.length();
        int N = txt.length();

        int j = 0;
        for(int i = 0; i < N; ++i){
            j = dp[j][txt.charAt(i)];
            if( j == M) return i - M +1;
        }
        return -1;
    }

}
