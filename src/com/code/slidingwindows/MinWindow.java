package com.code.slidingwindows;

import java.util.*;
public class MinWindow {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] sMatch = new int[128];
        int[] tMatch = new int[128];
        for (Character ch : t.toCharArray()) {
            tMatch[ch]++;
        }

        int ansLeft = -1, ansRight = s.length();
        for (int left = 0, right = 0; right < s.length() && left < s.length(); ++right) {
            char ch = s.charAt(right);
            sMatch[ch]++;
            while (isMatch(sMatch, tMatch)) {
                char leftCh = s.charAt(left);
                sMatch[leftCh]--;
                if (ansRight - ansLeft > right - left) {
                    ansRight = right;
                    ansLeft = left;
                }
                ++left;
            }
        }

        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    private boolean isMatch(int[] sMatch, int[] tMatch) {
        for (int i = 'A'; i <= 'z'; ++i) {
            if (sMatch[i] < tMatch[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean match(Map<Character, Integer> match, Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : match.entrySet()) {
            Character key = entry.getKey();
            int count = entry.getValue();
            Integer current = map.getOrDefault(key, 0);
            if (current < count) {
                return false;
            }
        }
        return true;

    }
}
