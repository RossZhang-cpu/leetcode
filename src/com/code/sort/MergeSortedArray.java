package com.code.sort;

import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int end = nums1.length - 1;
        int j = n - 1;
        for (int i = m - 1; i >= 0 && j >= 0;) {

            if(nums1[i] > nums2[j]) {
                nums1[end] = nums1[i];
                --i;
            } else {
                nums1[end] = nums2[j];
                --j;
            }
            --end;

        }
        while (j >= 0) {
            nums1[end--] = nums2[j--];
        }



    }


    public static void main(String[] args) {
        MergeSortedArray sortedArray = new MergeSortedArray();
        int[]  num1 = {4, 5, 6, 0, 0, 0};
        int[]  num2 = {1, 2, 3};

        sortedArray.merge(num1, 3, num2, 3);

        Arrays.stream(num1).forEach(System.out::println);
    }
}
