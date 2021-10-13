package com.code;

import java.util.*;

public class ReFindWay {

    public int minReorder(int n, int[][] connections) {
       Map<Integer, HashSet<Integer>> map = new HashMap<>();
       boolean[] visited = new boolean[n];

       for(int i = 0; i < connections.length; ++i){
           map.computeIfAbsent(connections[i][0], k -> new HashSet<>());
           map.get(connections[i][0]).add(i);

           map.computeIfAbsent(connections[i][1], k -> new HashSet<>());
           map.get(connections[i][1]).add(i);
       }

       Queue<Integer> queue = new LinkedList<>();
       queue.offer(0);
       int result = 0;

       while (!queue.isEmpty()){
           int head = queue.poll();
           for(int numOfWay : map.get(head)){
                if(visited[numOfWay]) continue;
                visited[numOfWay] = true;

               int a = connections[numOfWay][0];
               int b = connections[numOfWay][1];

               result += ((a == numOfWay) ? 1 : 0);   // a == curr 通路
               a = ((a == numOfWay) ? b : a);
               queue.offer(a);

           }
       }
       return result;
    }

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    /*
    利用改造的邻接表来存图
     */
    public int minReorderDFS(int n, int[][] connections) {
        int result = 0;
        // 花了一段时间才理解conn_idx。。维护的是含有城市i的connection的index
        Map<Integer, Set<Integer>> conn_idx = new HashMap<>();
        boolean[] visited = new boolean[n];  //对应于变

        for (int i = 0; i < connections.length; i++) {
            int city1 = connections[i][0];
            int city2 = connections[i][1];

            if (!conn_idx.containsKey(city1)) conn_idx.put(city1, new HashSet<>());
            conn_idx.get(city1).add(i);


            if (!conn_idx.containsKey(city2)) conn_idx.put(city2, new HashSet<>());
            conn_idx.get(city2).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i : conn_idx.get(curr)) {
                if (visited[i]) continue;
                visited[i] = true;

                int a = connections[i][0];
                int b = connections[i][1];

                result += ((a == curr) ? 1 : 0);   // a == curr 通路
                a = ((a == curr) ? b : a);
                queue.offer(a);
            }
        }
        return result;
    }
}
