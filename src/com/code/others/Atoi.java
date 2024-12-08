package com.code.others;

public class Atoi {

    public int myAtoi(String s) {
        s = s.trim();
        if( s == null || s.length() == 0 )
            return 0;

        char[] ch = s.toCharArray();
        int result = 0;
        int i = 0;
        boolean isNegative = false;
        if(ch[i] == '-' ) {
            isNegative = true;
            ++i;
        }else if(ch[i] == '+'){
            ++i;
        }

        for(; i < ch.length; ++i){
            if(ch[i] >= '0' && ch[i] <= '9') {
                int num = ch[i] - '0';
                //在未越界之前判断
                if (result > (Integer.MAX_VALUE - num) / 10) {
                     return  isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }else
                    result = result * 10 + num;
            }else break;
        }

        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
//        LinkedHashMap
//        int i = new Atoi().myAtoi("-42");
//        System.out.println(i);
    }
}
