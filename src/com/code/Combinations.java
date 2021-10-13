package com.code;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        getCombine(n, k, 1, new ArrayList<>());
        return ans;
    }

    public void getCombine(int n, int k, int start, List<Integer> list) {
        if(list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i <= n; i++) {
            list.add(i);
            getCombine(n, k, i+1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new Combinations().combine(4, 2);
        System.out.println(combine.toString());
    }
}
