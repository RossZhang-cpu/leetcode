package com.code.bdfs;

import java.util.*;

public class OpenLock {

    public String plusOne(String str, int i){
        char[] ch = str.toCharArray();
        if(ch[i] == '9')  ch[i] = '0';
        else ch[i] += 1;
        return String.valueOf(ch);
    }

    public String minusOne(String str, int i){
        char[] ch = str.toCharArray();
        if(ch[i] == '0')  ch[i] = '9';
        else ch[i] -= 1;
        return String.valueOf(ch);
    }

    public int openLock(String[] deadends, String target) {
        String str = "0000";
        Queue<String> queue = new LinkedList<String>();

        List<String> deadlist = new ArrayList<>();
        int step = 0;
        Collections.addAll(deadlist, deadends);
        Set<String> vis = new HashSet<>();
        vis.add("0000");
        queue.offer("0000");

        while(!queue.isEmpty()){
            int sz = queue.size();
            for(int m =0 ; m < sz; ++m) {
                String temp = queue.poll();
                if (deadlist.contains(temp)) continue;
                if(temp.equals(target))  return step;

                for (int i = 0; i < str.length(); ++i) {
                    String plus = plusOne(temp, i);
                    if(!vis.contains(plus)) {    //如果未被访问
                        queue.offer(plus);
                        vis.add(plus);
                    }
                    String minus = minusOne(temp, i);
                    if(!vis.contains(minus)) {
                        queue.offer(minus);
                        vis.add(minus);
                    }
                }
            }
            ++step;
        }
        return -1;
    }

    public int TwoBFS(String[] deadends, String target) {
        String str = "0000";
        Queue<String> q1 = new LinkedList<String>();
        Queue<String> q2 = new LinkedList<String>();

        Set<String> deadlist = new HashSet<>();
        int step = 0;
        Collections.addAll(deadlist, deadends);
        Set<String> vis = new HashSet<>();
        vis.add("0000");
        q1.offer("0000");
        q2.offer(target);

        while(!q1.isEmpty() && !q2.isEmpty()){
            int sz = q1.size();
            for(int m =0 ; m < sz; ++m) {
                String temp = q1.poll();
                if (deadlist.contains(temp)) continue;
                if(q2.contains(temp))  return step;

                for (int i = 0; i < 4; ++i) {
                    String plus = plusOne(temp, i);
                    if(!vis.contains(plus)) {    //如果未被访问
                        q1.offer(plus);


                        vis.add(plus);
                    }
                    String minus = minusOne(temp, i);
                    if(!vis.contains(minus)) {
                        q1.offer(minus);
                        vis.add(minus);
                    }
                }
            }
            ++step;
            Queue<String> t = new LinkedList<>(q2);
            q2 = q1;
            q1 = t;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] str = {"0201","0102","1212","2002"};
        String target = "9000";
        System.out.println(new OpenLock().TwoBFS(str, target));
    }

}
