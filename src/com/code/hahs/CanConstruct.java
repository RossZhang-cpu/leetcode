package com.code.hahs;

import java.util.HashMap;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 */
public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = magazine.toCharArray();
        char[] ransomNoteCharArray = ransomNote.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : chars) {
            int i = map.getOrDefault(ch, 0);
            map.put(ch, ++i);
        }

        boolean flag = true;
        for (char ch : ransomNoteCharArray) {
//            Integer i = map.get(ch);
            Integer i = map.computeIfPresent(ch, (k, v) -> --v);
            if (i == null || i < 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        CanConstruct canConstruct = new CanConstruct();

    }
}
