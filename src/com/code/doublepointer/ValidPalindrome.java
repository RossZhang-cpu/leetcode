package com.code.doublepointer;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        char[] origin = s.toCharArray();

        List<Character> list = new ArrayList<>();

        for (char ch : origin) {
            if (!Character.isLetterOrDigit(ch)) {
                continue;
            }
            char lowerCase = Character.toLowerCase(ch);
            list.add(lowerCase);
        }

        boolean flag = true;
        for (int low = 0, high = list.size() - 1; low < high; ++low, --high) {
            Character lowCh = list.get(low);
            Character highCh = list.get(high);

            if (!lowCh.equals(highCh)) {
                flag = false;
                break;
            }
        }

        return flag;

    }
}
