package com.code.greedy;

import java.util.*;

public class LeastInterval {

    public int leastInterval(char[] tasks, int n) {
        if(n == 0){
            return tasks.length;
        }
        int ans;
        Map<Character, Integer> map = new HashMap<>();
        //从出现次数最多的开始
        //按次数的频率依次递减
        int max = 0;
        for(char c : tasks){
            if(map.get(c) == null){
                map.put(c, 1);
            }else {
                int fre = map.get(c);
                map.put(c, ++fre);
            }
            max = Math.max(map.get(c), max);
        }
        int numOfChar  = map.keySet().size();
        int maxOfChar = 0;
        for(Integer elem : map.values()){
            if(elem == max){
                ++maxOfChar;
            }
        }
        return Math.max(tasks.length, (max + 1) * (numOfChar - 1) + maxOfChar );
    }

    public static void main(String[] args) {
        LeastInterval leastInterval = new LeastInterval();
        char[] tasks = {'A', 'B', 'C', 'D', 'E', 'A', 'B', 'C', 'D', 'E'};
        int n = 4;
        int i = leastInterval.leastInterval(tasks, n);
        System.out.println(i);
    }
}
