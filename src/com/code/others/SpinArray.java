package com.code.others;

import java.util.HashMap;

public class SpinArray {

    /*
     *两个递增序列的数组，旋转数组输出最小
     */
    public int min(int[] data) throws Exception {
        if (data == null || data.length == 0)
            throw new Exception("输入错误");

        int s = 0;
        int e = data.length - 1;
        int minIndex = s;

        while (data[s] >= data[e]) {
            if (e - s <= 1) {
                minIndex = e;
                break;
            }

            minIndex = (s + e) / 2;
            if (data[s] == data[e] && data[s] == data[minIndex]) {   //如果三个值相等，无法确定当前的数属于哪个序列  [1, 0, 1,1,1]  [1,1,1,0,1]
                return minInOrder(data, s, minIndex, e);             //顺序查找
            }

            if (data[minIndex] >= data[s]) { //此时为第一个序列
                s = minIndex;
            } else if (data[minIndex] <= data[s]) {   //此时中间元素为第二个递增序列
                e = minIndex;
            }
        }

        return (data[minIndex]);
    }

    public int minInOrder(int[] data, int s, int minIndex, int e) {
        int result = data[s];
        for (s = s + 1; s < e; ++s) {
            if (data[s] < result)
                result = data[s];
        }
        return result;
    }

    public static void main(String[] args) {
//        HashMap<String, Double> map = new HashMap<>();
//        map.put("11", 2.0);
//        double ere = map.get("3");
//        System.out.println(ere);
        String regx = "-";
    }
}