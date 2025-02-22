package com.code.hash;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        boolean lengthEqual = s.length() == t.length();
        if (!lengthEqual) return lengthEqual;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.compute(s.charAt(i), (key, value) -> value == null ? 1 : value + 1);
        }

        for (int i = 0; i < t.length(); ++i) {
            Integer res = map.computeIfPresent(t.charAt(i), (key, value) -> --value);
            if (res == null || res < 0) {
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        isAnagram.isAnagram("anagram", "nagaram");
    }
}
