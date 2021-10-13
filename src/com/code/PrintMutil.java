package com.code;

import java.util.*;

public class PrintMutil {

    public void printMutil() {
        for (int i = 1; i <= 9; ++i) {        //行
            for (int j = 1; j <= i; ++j) {
                int result = i * j;
                int tap = 2;
                if (result / 10 > 0) --tap;
                for (int m = 0; m < tap && j > 1; ++m)
                    System.out.print(" ");
                System.out.print(result);
            }
            System.out.println();
        }
    }

    public void printMutilRight() {
        for (int i = 1; i <= 9; ++i) {        //行
            for (int n = 1; n < i; ++n) {
                if (n == 1) System.out.print(" ");
                else System.out.print("   ");
            }
            for (int j = i; j <= 9; ++j) {
                int result = i * j;
                int tap = 2;
                if (result / 10 > 0) --tap;
                for (int m = 0; m < tap && j > 1; ++m)
                    System.out.print(" ");

                System.out.print(result);
            }
            System.out.println();
        }
    }

    public List<Integer> depulicate(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Arrays.sort(nums);
        var list = new LinkedList<Integer>();
        for (int i : nums) list.add(i);
        for (int i = 0; i < list.size(); ++i) {    //去除没有重复的
            if (i == 0) {
                if (list.get(i) != list.get(i + 1)) {
                    list.remove(i);
                    --i;
                }
            } else if (i == list.size() - 1) {
                if (list.get(i) != list.get(i - 1)) {
                    list.remove(i);
                    --i;
                }
            } else if (i < list.size() - 1)
                if (list.get(i) != list.get(i - 1) && list.get(i) != list.get(i + 1)) {
                    list.remove(i);
                    --i;
                }
        }

        return list;

    }

        public static void main (String[]args){

        }
    }

