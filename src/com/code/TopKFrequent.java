package com.code;

import java.util.*;

//Given an integer array nums and an integer k, return the k most frequent eleme
//nts. You may return the answer in any order.
//
//
// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// Example 2:
// Input: nums = [1], k = 1
//Output: [1]
//
//
// Constraints:
//
//
// 1 <= nums.length <= 105
// k is in the range [1, the number of unique elements in the array].
// It is guaranteed that the answer is unique.
//
// Follow up: Your algorithm's time complexity must be better than O(n log n), w
//here n is the array's size.
//
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int frequent;
        for(int i : nums){
            if(map.get(i) == null){
                frequent = 1;
                map.put(i, frequent);
            }else {
                frequent = map.get(i) + 1;
                map.put(i, frequent);
            }
            max = Math.max(frequent, max);
        }

        List<Integer>[] freNums = new ArrayList[nums.length + 1];
        for(Map.Entry<Integer, Integer> set : map.entrySet()){
                int index = set.getValue();
                int key = set.getKey();
                if(freNums[index] == null){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(key);
                    freNums[index] = temp;
                }else {
                    freNums[index].add(key);
                }
        }

        int[] result = new int[k];
        int index = 0;
        for(int i = freNums.length - 1; index < k ; --i){
            if(freNums[i] != null){
                for(int m : freNums[i]){
                    result[index] = m;
                    ++index;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequent frequent = new TopKFrequent();
        int[] ints = new int[]{1};
        int[] data = frequent.topKFrequent( ints, 1);
        for(int n : data){
            System.out.print(n + " ");
        }
    }
}
