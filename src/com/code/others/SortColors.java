package com.code.others;

public class SortColors {
//    给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//    此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//荷兰国 --> 三色旗    三指针，确定边界
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1, curr = 0;

        while (curr <= p2){
            if(nums[curr] == 0){
                int temp = nums[p0];
                nums[p0] = nums[curr];
                nums[curr] = temp;
                ++p0;
                ++curr;
            }else if(nums[curr] == 2){
                int temp = nums[p2];
                nums[p2] = nums[curr];
                nums[curr] = temp;
                --p2;
            }else ++curr;
        }
    }

    public static void main(String[] args) {
        SortColors colors = new SortColors();
        int[] nums = {1,2, 0};
        colors.sortColors(nums);
        for(int s : nums) System.out.println(s);
    }
}
