package com.code.sort;

import java.util.Arrays;

public class MyQuickSort {

    public int[] quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return nums;
        }

        int left = start, right = end;
        int pivot = nums[left];
        for (; left <= right; ) {
            while (left <= right && nums[left] <= pivot) {
                ++left;
            }

            while (left <= right && nums[right] > pivot ) {
                --right;
            }

            if (left > right) {
                nums[start] = nums[right];
                nums[right] = pivot;
                break;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        quickSort(nums, start, right - 1);
        quickSort(nums, right + 1, end);
        return nums;
    }

    public static void main(String[] args) {
        MyQuickSort quickSort = new MyQuickSort();
        int[] nums = {3, 34, 12,34, 1, 5, 2,17};
        int[] ints = quickSort.quickSort(nums, 0, nums.length - 1);
        Arrays.stream(ints).forEach(System.out::println);
    }

}
