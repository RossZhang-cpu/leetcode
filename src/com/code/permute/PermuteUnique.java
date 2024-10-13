package com.code.permute;

import java.util.*;

public class PermuteUnique {


//    public  <T, P, C> C main1(T a, P b, C c) {
//
//    }

    public static void main(String[] args) {
        PermuteUnique permute1 = new PermuteUnique();
        int[] nums = {1, 1, 3, 2, 3};
        List<List<Integer>> permute = permute1.permuteUnique(nums);
    }

    /**
     * <a href="https://leetcode.cn/problems/7p8L0Z/description/">...</a>
     * 给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Map<Integer, Set<String>> memory = new HashMap<>();
        dfs(result, new ArrayList<>(), nums, visited, memory);
        result.forEach(System.out::println);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] visited,
                     Map<Integer, Set<String>> memory) {
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.max(current.size() - 1, 0);
            StringBuilder prefix = new StringBuilder();
            current.forEach(v -> prefix.append(v).append(","));
            prefix.append(nums[i]);
            if (!visited[i] && !isDuplicatePrefix(prefix, index, memory)) {
                Set<String> set = memory.getOrDefault(index, new HashSet<>());
                set.add(prefix.toString());
                memory.put(index, set);

                current.add(nums[i]);
                visited[i] = true;
                dfs(result, current, nums, visited, memory);

                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }

        if (nums.length == current.size()) {
            result.add(new ArrayList<>(current));
        }
    }

    private boolean isDuplicatePrefix(StringBuilder prefix, int index, Map<Integer, Set<String>> memory) {
        return memory.get(index) != null && memory.get(index).contains(prefix.toString());
    }


    //方法2 进行排序
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs2(result, new ArrayList<>(), nums, visited);
        result.forEach(System.out::println);
        return result;
    }

    //保证在填第 idx 个数的时候重复数字只会被填入一次即可。
    private void dfs2(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] visited) {
        for (int i = 0; i < nums.length; ++i) {
            //保证在填第 idx 个数的时候重复数字只会被填入一次即可。而在本题解中，我们选择对原数组排序，保证相同的数字都相邻，然后每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」
            //
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            current.add(nums[i]);
            visited[i] = true;
            dfs2(result, current, nums, visited);

            current.remove(current.size() - 1);
            visited[i] = false;
        }

        if (nums.length == current.size()) {
            result.add(new ArrayList<>(current));
        }
    }
}
