package com.code.doublepointer;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int tIndex = -1;
        boolean flag = true;
        for (int i = 0; i < sChars.length; ++i) {

            ++tIndex;
            while (tIndex < tChars.length) {
                if (tChars[tIndex] != sChars[i]) {
                    ++tIndex;
                } else break;
            }

            if (tIndex >= tChars.length) {
                flag = false;
                break;
            }
        }


        return flag;

    }
}
