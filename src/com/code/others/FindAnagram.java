package com.code.others;

import java.util.ArrayList;
import java.util.List;

public class FindAnagram {

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int m = 0; m < chars.length - p.length() + 1; ++m){
            int i = p.indexOf(chars[m]);
            if (i >= 0 ){
                StringBuilder builder = new StringBuilder(p);
                builder.deleteCharAt(i);
                if(isSameAnagrams(chars, m, p, builder)){
                    list.add(m);
                }
            }
        }
        return list;
    }

    private boolean isSameAnagrams(char[] chars, int m, String p, StringBuilder builder) {
        for ( int i = 1; i < p.length(); ++i){
            int index = builder.indexOf(String.valueOf(chars[m + i]));
            //如果包含且只出现一次 继续
            if (index >= 0 ){
                builder.deleteCharAt(index);
            }else {
                return false;
            }
        }
        return true;
    }


}
