package com.code.string;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 *
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
public class FirstOccurrenceInAString {

    public int strStr1(String haystack, String needle) {
        int res = -1;
        if (haystack.contains(needle)) {
            res = haystack.indexOf(needle);
        }
        return res;
    }

    public int strStrKMP(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int[] next = new int[needle.length()];
        next[0] = 0;
        char[] chars = needle.toCharArray();

        //construct next array
        for (int j = 0, i = 1; i < needle.length(); ++i) {
            while (j > 0 && chars[i] != chars[j]) {
                j = next[j - 1];
            }

            if (chars[j] == chars[i]) {
                ++j;
                next[i] = j;
            }
        }
        int j = 0;
        int res = -1;

        for (int i = 0; i < haystack.length();) {
            while (j < needle.length() && i < haystack.length() && haystack.charAt(i) == needle.charAt(j)) {
                ++j;
                ++i;
            }
            if (j >= needle.length()) {
                res = i - j;
                break;
            }
            if (i >= haystack.length()) {
                break;
            }

            while (j >= 1 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            if (j == 0 && haystack.charAt(i) != needle.charAt(j)) {
                ++i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FirstOccurrenceInAString inAString = new FirstOccurrenceInAString();
        inAString.strStrKMP("aabaaabaaac", "aabaaac");
    }
}
