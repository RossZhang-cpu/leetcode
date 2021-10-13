package com.code.others;

import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0)
            return null;

        int len = candidates.length;
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, len, path, target, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, Deque<Integer> path, int target, List<List<Integer>> res) {
        if(target < 0)
            return;

        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = begin; i < len; ++i){
            path.addFirst(candidates[i]);

            dfs(candidates, begin, len, path, target - candidates[i], res);

            path.removeFirst();
        }
    }

}
