package com.code.dynamicprogram;

import java.util.*;

public class InterleavingString {

    /**
     * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
     *
     * An interleaving of two strings s and t is a configuration where s and t are divided into n and m
     * substrings
     *  respectively, such that:
     *
     * s = s1 + s2 + ... + sn
     * t = t1 + t2 + ... + tm
     * |n - m| <= 1
     * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
     * Note: a + b is the concatenation of strings a and b.
     *
     * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * Output: true
     * Explanation: One way to obtain s3 is:
     * Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
     * Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
     * Since s3 can be obtained by interleaving s1 and s2, we return true.
     */

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n][m];
    }



    public boolean isInterleave2(String s1, String s2, String s3) {

        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char[] ch3 = s3.toCharArray();
        HashSet<String> filterSet = new HashSet<>();
        LinkedList<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new AbstractMap.SimpleEntry<>(-1, -1));
        filterSet.add(convertToString(-1, -1));

        for (char ch : ch3) {
            int solutionSize = queue.size();
            for (int i = 0; i < solutionSize; ++i){
                Map.Entry<Integer, Integer> index = queue.poll();
                boolean remove = filterSet.remove(convertToString(index.getKey(), index.getValue()));
                int indexOfCh1 = index.getKey() + 1;
                int indexOfCh2 = index.getValue() + 1;
                if (indexOfCh1 < ch1.length && ch1[indexOfCh1] == ch) {
                    //pick up this element
                    if (!filterSet.contains(convertToString(indexOfCh1, index.getValue()))) {
                        filterSet.add(convertToString(indexOfCh1, index.getValue()));
                        queue.offer(new AbstractMap.SimpleEntry<>(indexOfCh1, index.getValue()));
                    }
                }

                if (indexOfCh2 < ch2.length && ch2[indexOfCh2] == ch) {
                    if (!filterSet.contains(convertToString(index.getKey(), indexOfCh2))) {
                        filterSet.add(convertToString(index.getKey(), indexOfCh2));
                        queue.offer(new AbstractMap.SimpleEntry<>(index.getKey(), indexOfCh2));
                    }

                }
            }
            if (queue.isEmpty()) {
                return false;
            }
        }
        Map.Entry<Integer, Integer> entry = queue.poll();
        return entry!= null && entry.getKey() == ch1.length - 1 && entry.getValue() == ch2.length -1;

    }

    private String convertToString(int index1, int index2) {
        return String.valueOf(index1) + "_" + String.valueOf(index2);
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        InterleavingString interleavingString = new InterleavingString();
        boolean interleave = interleavingString.isInterleave(s1, s2, s3);
        System.out.println(interleave);
    }
}
