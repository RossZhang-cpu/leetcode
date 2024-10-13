package com.code.permute;

import java.util.ArrayList;
import java.util.List;

public class Permute1 {

    public static void main(String[] args) {
        Permute1 permute1 = new Permute1();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute1.permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(result, new ArrayList<>(), nums, visited);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] visited) {
        for (int i = 0; i < nums.length; ++i) {
            if (!visited[i]) {
                current.add(nums[i]);
                visited[i] = true;
                dfs(result, current, nums, visited);

                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }

        if (nums.length == current.size()) {
            result.add(new ArrayList<>(current));
        }
    }
}
