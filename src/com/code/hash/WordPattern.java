package com.code.hash;

import java.util.HashMap;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        HashMap<String, Character> map = new HashMap<>();

        char[] patternCharArray = pattern.toCharArray();
        if (patternCharArray.length != strings.length) {
            return false;
        }

        for (int i = 0; i < strings.length; ++i) {

            Character value = map.get(strings[i]);
            if (value == null) {
                if (!map.containsValue(pattern.charAt(i))) {
                    map.put(strings[i], pattern.charAt(i));
                } else return false;
            } else {
                boolean flag =  value.equals(pattern.charAt(i));
                if (!flag) return false;
            }
        }

        return true;
    }
}
