package com.code.hash;

import java.util.Collection;
import java.util.Formattable;
import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < target.length; ++i) {
            Character c = map.get(source[i]);

            if ( (c != null && c == target[i]) || (c == null && !map.containsKey(source[i]) && !map.containsValue(target[i]))) {
                map.putIfAbsent(source[i], target[i]);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsIsomorphic isIsomorphic = new IsIsomorphic();
        boolean isomorphic = isIsomorphic.isIsomorphic("badc", "baba");
        System.out.println(isomorphic);
    }
}
