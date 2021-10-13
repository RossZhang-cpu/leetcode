package com.code;

public class CountOne {

    public int NumberOf1(int n){
        int count = 0;
        int flag = 1;
        while (flag >= 1){
            if((n&flag) >= 1){
                count++;
            }
            flag = flag<<1;
        }
        return count;
    }

    //a better way
    public int NumberOf1Better(int n){
        int count = 0;
        while (n > 0){
            n = n & (n -1);
            ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        CountOne countOne = new CountOne();
        System.out.println(countOne.NumberOf1Better(127));
    }
}
