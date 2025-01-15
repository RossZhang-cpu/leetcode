package com.code.string;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char[] array = s.toCharArray();
        int length = 0;
        for (int i = array.length - 1; i >= 0; --i) {
            if (array[i] == ' ') {
                if (length == 0) {
                    continue;
                } else {
                    break;
                }
            }

            ++length;
        }

        return length;

    }

}
