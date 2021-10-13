package com.code.others;
import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            List<String> list = map.getOrDefault(Arrays.toString(temp), new ArrayList<>());
            list.add(str);
            map.put(Arrays.toString(temp), list);
//            map.computeIfAbsent();
        }
        return new ArrayList<>(map.values());
    }



    public static void main(String[] args) {
        GroupAnagrams anagrams = new GroupAnagrams();
        String[] strings = {"", ""};
        List<List<String>> lists = anagrams.groupAnagrams(strings);
        System.out.println(lists.toString());
    }
}
