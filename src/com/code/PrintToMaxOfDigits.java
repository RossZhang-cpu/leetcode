package com.code;

import java.util.Arrays;

public class PrintToMaxOfDigits {
    public void printToMaxOfDigits(int n){
        if( n <= 0)
            return;

        char[] chars = new char[n];
        Arrays.fill(chars, '0');
        while (!increment(chars)){
            System.out.printf(String.valueOf(chars) + " ");  //逆置c
        }
    }

    public boolean increment(char[] chars){
        int isTakeOver = 0;
        boolean isOverFlow = false;
        int nSum = 0;

        for(int i = chars.length - 1; i >= 0; --i){         //最后一位存储最低位
            nSum = chars[i] - '0' + isTakeOver;
            if(i == chars.length - 1)
                ++nSum;
            if(nSum >= 10){         //产生进位
                if(i == 0){
                    isOverFlow = true;
                }else{
                  nSum -= 10;
                  isTakeOver = 1;
                  chars[i] = (char) ('0' + nSum);
                }
            }else {
                isTakeOver = 0;
                chars[i] = (char) (nSum + '0');
                break;
            }

        }
        return isOverFlow;
    }

    public static void main(String[] args) {
        PrintToMaxOfDigits printToMaxOfDigits = new PrintToMaxOfDigits();
        printToMaxOfDigits.printToMaxOfDigits(3);
    }
}
