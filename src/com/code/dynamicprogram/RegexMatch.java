package com.code.dynamicprogram;

public class RegexMatch {

    //. 匹配任意单个字符
    //* 匹配零个或多个前面的元素
    public boolean isMatch(String s, String p){
        if(p.length() <= 0 && s.length() > 0)
            return false;

        char ch = p.charAt(0);
        boolean first = false;
        if( ch == s.charAt(0) || ch == '.' ){
            first = true;
        }

        if(s.length() >= 2 && p.charAt(1) == '*')
            return isMatch(s, p.substring(2)) ||
                    first && isMatch(s.substring(1), p);
        else
            return first && isMatch(s.substring(1), p.substring(1));
        
    }
}
